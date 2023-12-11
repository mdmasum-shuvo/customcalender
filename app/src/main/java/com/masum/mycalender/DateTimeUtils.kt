package com.masum.mycalender

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import java.util.concurrent.TimeUnit
import javax.xml.datatype.DatatypeConstants.DAYS


object DateTimeUtils {


    const val MMM_YYYY = "MMM YYYY"

    private var calendar: Calendar? = null
    var currentPosition = 0

    @SuppressLint("SimpleDateFormat")
    fun getCurrentDateTime(format: String): String {
        val formatter = SimpleDateFormat(format)
        val date = Date()
        return formatter.format(date)
    }

    @SuppressLint("SimpleDateFormat")
    fun getCurrentDateTimeBn(format: String): String {
        val formatter = SimpleDateFormat(format, Locale("bn"))
        val date = Date()
        return formatter.format(date)
    }

    @SuppressLint("SimpleDateFormat")
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



