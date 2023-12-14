package com.masum.mycalender

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.*
import java.util.*


object DateTimeUtils {


    const val MMM_YYYY_STRING = "MMM yyyy"
    const val MM_YYYY_NUMBER = "MM/yyyy"
    const val DD_MM_YYYY = "dd/MM/yyyy"
    const val dd = "dd"

    private var calendar: Calendar? = null
    var currentPosition = 0

    @SuppressLint("SimpleDateFormat")
    fun getCurrentDateTime(format: String): String {
        val formatter = SimpleDateFormat(format)
        val date = Date()
        return formatter.format(date)
    }

    fun convertStringToDate(format: String, dateStr: String): Date {
        val formatter = SimpleDateFormat(format)
        return formatter.parse(dateStr)
    }

    fun actualMonth(month: Int): Int {
        return month + 1
    }

    fun actualToCalenderMonth(month: Int): Int {
        return month - 1
    }

    @SuppressLint("SimpleDateFormat")
    fun getCurrentDateTimeBn(format: String): String {
        val formatter = SimpleDateFormat(format, Locale("bn"))
        val date = Date()
        return formatter.format(date)
    }

    fun changeDateFormat(currentFormat: String, newFormat: String, date: String): String? {
        val datePickerFormat = SimpleDateFormat(currentFormat, Locale.US)
        val myFormat = SimpleDateFormat(newFormat)
        return try {
            val dateFromUser = datePickerFormat.parse(date)
            myFormat.format(dateFromUser!!)
        } catch (e: ParseException) {
            e.printStackTrace()
            null
        }
    }


}



