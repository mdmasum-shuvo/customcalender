package com.masum.mycalender.customer_calender.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.masum.mycalender.ui.theme.green


@Composable
fun DateView(selectedDate:String="OCT 2023") {
    Text(
        text = selectedDate,
        style = MaterialTheme.typography.headlineLarge,
        color = green
    )
}