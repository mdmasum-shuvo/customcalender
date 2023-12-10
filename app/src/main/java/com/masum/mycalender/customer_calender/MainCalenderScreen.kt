package com.masum.mycalender.customer_calender

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masum.mycalender.customer_calender.data.ShowDayName
import com.masum.mycalender.ui.theme.MycalenderTheme
import com.masum.mycalender.ui.theme.background


@Composable
fun MainCalenderScreen() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        ShowDayName()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
        ) {

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DayNameItemPreview() {
    MycalenderTheme {
        Surface(color = background) {
            MainCalenderScreen()
        }
    }
}
