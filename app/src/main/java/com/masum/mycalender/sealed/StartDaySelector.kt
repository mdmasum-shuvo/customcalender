package com.masum.mycalender.sealed

sealed class StartDaySelector{
    data class SUNDAY(val name: String="SUN", val value:Int=0):StartDaySelector()
    data class MONDAY(val name: String="Mon", val value:Int=1): StartDaySelector()
    data class TUESDAY(val name: String="Tue", val value:Int=2):StartDaySelector()
    data class WEDNESDAY(val name: String="Wed", val value:Int=3):StartDaySelector()
    data class THURSDAY(val name: String="Thu", val value:Int=4):StartDaySelector()
    data class FRIDAY(val name: String="Fri", val value:Int=5):StartDaySelector()
    data class SATURDAY(val name: String="Sat", val value:Int=6):StartDaySelector()
}