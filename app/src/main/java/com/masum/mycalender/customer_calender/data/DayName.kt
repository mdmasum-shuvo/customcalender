package com.masum.mycalender.customer_calender.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.masum.mycalender.customer_calender.component.DayNameItem


data class DayName(var name: String)

var list = ArrayList<DayName>()

@Composable
fun ShowDayName() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        DayNameItem("S")
        DayNameItem("M")
        DayNameItem("T")
        DayNameItem("W")
        DayNameItem("T")
        DayNameItem("F")
        DayNameItem("S")

    }
}