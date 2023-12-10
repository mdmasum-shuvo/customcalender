package com.masum.mycalender.customer_calender

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masum.mycalender.customer_calender.data.DayName
import java.text.SimpleDateFormat
import java.util.Date

class CalenderViewModel : ViewModel() {


    var list = ArrayList<DayName>()
    var dateList = arrayOfNulls<Int>(28)

    private var _selectedMonth=MutableLiveData<String>()

    val selectedMonth :LiveData<String>
        get() = _selectedMonth

    val currentDayFfWeek=3
    var currentMonth=0
    init {
        showDayName()
        _selectedMonth.value=getCurrentDateTime()
        println(getCurrentDateTime())
    }
    private fun showDayName() {
        list = ArrayList()
        list.add(DayName("S"))
        list.add(DayName("M"))
        list.add(DayName("T"))
        list.add(DayName("W"))
        list.add(DayName("T"))
        list.add(DayName("F"))
        list.add(DayName("S"))
    }

    private fun getCurrentDateTime(): String {
        val formatter = SimpleDateFormat("MMM YYYY")
        val date = Date()
        return formatter.format(date)
    }
}