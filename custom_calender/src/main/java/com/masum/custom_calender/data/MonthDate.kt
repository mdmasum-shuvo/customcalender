package com.masum.custom_calender.data

data class MonthDate(
    val date: Int,
    val isCurrent: Boolean = false,
    val isHasEvent: Boolean = false,
    val actualDate: String?=null
)
