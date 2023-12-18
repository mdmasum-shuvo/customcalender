package com.masum.custom_calender.main_file

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masum.custom_calender.data.DayName
import com.masum.custom_calender.data.MonthDate

import java.text.SimpleDateFormat
import java.time.YearMonth
import java.util.Calendar
import java.util.Date


class CalenderViewModel : ViewModel() {


    val list = ArrayList<DayName>()


    private var _dateList = MutableLiveData<Int>()
    val dateList: LiveData<Int>
        get() = _dateList

    private var _selectedMonth = MutableLiveData<String>()


    val selectedMonth: LiveData<String>
        get() = _selectedMonth

    private var _calenderMonth = MutableLiveData<List<MonthDate>>()
    val calenderMonth: LiveData<List<MonthDate>>
        get() = _calenderMonth

    var currentMonth = DateTimeUtils.getCurrentDateTime(DateTimeUtils.MMM_YYYY_STRING)
    var currentDateNumber = DateTimeUtils.getCurrentDateTime(DateTimeUtils.dd)
    private var _startDayOfMonth = MutableLiveData<Int>()
    val startDayOfMonth: LiveData<Int>
        get() = _startDayOfMonth

    val selectedExploreIndex = MutableLiveData<Int>(-1)

    val eventList = ArrayList<String>()


    init {
        showDayName()
        _selectedMonth.value = DateTimeUtils.getCurrentDateTime(DateTimeUtils.MMM_YYYY_STRING)
        println(getCurrentDateTime())
        getStartDayOfMonth(
            DateTimeUtils.getCurrentDateTime("yyyy").toInt(),
            DateTimeUtils.getCurrentDateTime("MM").toInt()
        )

       // generateCalender()
    }


    fun increaseMonth(date: String) {
        selectedExploreIndex.value = -1
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
        generateCalender()

    }

    fun decreaseMonth(date: String) {
        selectedExploreIndex.value = -1
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
        generateCalender()

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
        list.add(DayName("SUN"))
        list.add(DayName("MON"))
        list.add(DayName("TUE"))
        list.add(DayName("WED"))
        list.add(DayName("THU"))
        list.add(DayName("FRI"))
        list.add(DayName("SAT"))
    }

     fun createEvent(list: List<String>) {
        eventList.addAll(list)
/*        eventList.add("01/12/2023")
        eventList.add("09/12/2023")
        eventList.add("10/12/2023")
        eventList.add("11/12/2023")
        eventList.add("12/12/2023")
        eventList.add("17/12/2023")
        eventList.add("30/12/2023")
        eventList.add("27/12/2023")
        eventList.add("27/11/2023")*/
    }

    fun isHasEvent(date: String): Boolean {
        val changeDateFormat = DateTimeUtils.changeDateFormat(
            DateTimeUtils.dd_MMM_yyyy,
            DateTimeUtils.DD_MM_YYYY,
            date
        )
        for (item in eventList) {
            if (changeDateFormat == item) {
                return true
            }

        }
        return false
    }


    private fun getCurrentDateTime(): String {
        val formatter = SimpleDateFormat("MMM YYYY")
        val date = Date()
        return formatter.format(date)
    }

     fun generateCalender() {
        val list = ArrayList<MonthDate>()
        val gridSize = startDayOfMonth.value?.let { dateList.value?.plus(it) }
        for (i in 0 until gridSize!!) {
            if (i < (startDayOfMonth.value!!)) {
                list.add(MonthDate(-1))
            } else {
                val date = i - (startDayOfMonth.value!! - 1)
                val actualDate = "$date ${selectedMonth.value}"
                val isHasEvent = isHasEvent(actualDate)
                list.add(
                    MonthDate(
                        date = date,
                        actualDate = actualDate,
                        isCurrent = actualDate == DateTimeUtils.getCurrentDateTime(DateTimeUtils.dd_MMM_yyyy),
                        isHasEvent = isHasEvent
                    )
                )

            }
        }
        _calenderMonth.value = list
        Log.e("", "")

    }
}