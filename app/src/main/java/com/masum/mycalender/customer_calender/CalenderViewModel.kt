package com.masum.mycalender.customer_calender

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masum.mycalender.DateTimeUtils
import com.masum.mycalender.customer_calender.data.DayName
import com.masum.mycalender.sealed.StartDaySelector
import java.text.SimpleDateFormat
import java.time.YearMonth
import java.util.Calendar
import java.util.Date


class CalenderViewModel : ViewModel() {


    var list = ArrayList<DayName>()
    private var _dateList = MutableLiveData<Int>()
    val dateList: LiveData<Int>
        get() = _dateList

    private var _selectedMonth = MutableLiveData<String>()

    val selectedMonth: LiveData<String>
        get() = _selectedMonth

    private var _startDayOfMonth = MutableLiveData<Int>()
    val startDayOfMonth: LiveData<Int>
        get() = _startDayOfMonth

    var currentMonth = 0

    init {
        showDayName()
        _selectedMonth.value = DateTimeUtils.getCurrentDateTime(DateTimeUtils.MMM_YYYY_STRING)
        println(getCurrentDateTime())
        getStartDayOfMonth(
            DateTimeUtils.getCurrentDateTime("yyyy").toInt(),
            DateTimeUtils.getCurrentDateTime("MM").toInt()
        )
    }


    fun increaseMonth(date: String) {
        val selectedMonth = DateTimeUtils.changeDateFormat(
            DateTimeUtils.MMM_YYYY_STRING,
            "MM",
            date
        )!!.toInt()

        val selectedYear = DateTimeUtils.changeDateFormat(
            DateTimeUtils.MMM_YYYY_STRING,
            "yyyy",
            date
        )!!.toInt()

        val cal = Calendar.getInstance()
        cal.set(Calendar.YEAR, selectedYear)
        cal.set(Calendar.MONTH, DateTimeUtils.actualToCalenderMonth(selectedMonth))
        cal.set(Calendar.DAY_OF_MONTH, 1)

        cal.time = DateTimeUtils.convertStringToDate(DateTimeUtils.MMM_YYYY_STRING, date)
        cal.add(Calendar.MONTH, 1)
        val month = cal[Calendar.MONTH]
        val year = cal[Calendar.YEAR]
        getStartDayOfMonth(year, DateTimeUtils.actualMonth(month))
    }

    fun decreaseMonth(date: String) {
        val selectedMonth = DateTimeUtils.changeDateFormat(
            DateTimeUtils.MMM_YYYY_STRING,
            "MM",
            date
        )!!.toInt()

        val selectedYear = DateTimeUtils.changeDateFormat(
            DateTimeUtils.MMM_YYYY_STRING,
            "yyyy",
            date
        )!!.toInt()

        val cal = Calendar.getInstance()
        cal.set(Calendar.YEAR, selectedYear)
        cal.set(Calendar.MONTH, DateTimeUtils.actualToCalenderMonth(selectedMonth))
        cal.set(Calendar.DAY_OF_MONTH, 1)

        cal.time = DateTimeUtils.convertStringToDate(DateTimeUtils.MMM_YYYY_STRING, date)
        cal.add(Calendar.MONTH, -1)
        val month = cal[Calendar.MONTH]
        val year = cal[Calendar.YEAR]
        getStartDayOfMonth(year, DateTimeUtils.actualMonth(month))
    }


    fun getStartDayOfMonth(year: Int, month: Int) {
        val cal: Calendar = Calendar.getInstance()
        cal.set(Calendar.YEAR, year)
        cal.set(Calendar.MONTH, DateTimeUtils.actualToCalenderMonth(month))
        cal.set(Calendar.DAY_OF_MONTH, 1)
        System.out.println(cal.getTime())
        val month = cal[Calendar.MONTH]
        val year = cal[Calendar.YEAR]
        val length = YearMonth.of(year, DateTimeUtils.actualMonth(month)).lengthOfMonth()
        setSelectedTopMonthYear(year, month)
        _startDayOfMonth.value = cal[Calendar.DAY_OF_WEEK] - 1
        _dateList.value = length
    }

    private fun setSelectedTopMonthYear(year: Int, month: Int) {
        _selectedMonth.value = DateTimeUtils.changeDateFormat(
            DateTimeUtils.MM_YYYY_NUMBER,
            DateTimeUtils.MMM_YYYY_STRING,
            "${DateTimeUtils.actualMonth(month)}/$year"
        )
    }

    private fun showDayName() {
        list = ArrayList()
        list.add(DayName("SUN"))
        list.add(DayName("MON"))
        list.add(DayName("TUE"))
        list.add(DayName("WED"))
        list.add(DayName("THU"))
        list.add(DayName("FRI"))
        list.add(DayName("SAT"))
    }

    fun startDaySelectorPosition(dayName: String): Int {
        when (dayName) {
            StartDaySelector.MONDAY().name -> {
                return StartDaySelector.MONDAY().value
            }

            StartDaySelector.TUESDAY().name -> {
                return StartDaySelector.TUESDAY().value
            }

            StartDaySelector.WEDNESDAY().name -> {
                return StartDaySelector.WEDNESDAY().value
            }

            StartDaySelector.THURSDAY().name -> {
                return StartDaySelector.THURSDAY().value
            }

            StartDaySelector.FRIDAY().name -> {
                return StartDaySelector.FRIDAY().value
            }

            StartDaySelector.SATURDAY().name -> {
                return StartDaySelector.SATURDAY().value
            }

            StartDaySelector.SUNDAY().name -> {
                return StartDaySelector.SUNDAY().value
            }

            else -> {
                return 0
            }
        }
        return 0
    }


    private fun getCurrentDateTime(): String {
        val formatter = SimpleDateFormat("MMM YYYY")
        val date = Date()
        return formatter.format(date)
    }
}