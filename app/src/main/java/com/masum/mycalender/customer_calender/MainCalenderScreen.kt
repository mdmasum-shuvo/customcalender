package com.masum.mycalender.customer_calender

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masum.mycalender.customer_calender.component.DateItem
import com.masum.mycalender.customer_calender.component.DateView
import com.masum.mycalender.customer_calender.component.DayNameItem
import com.masum.mycalender.ui.theme.MycalenderTheme
import com.masum.mycalender.ui.theme.background


@Composable
fun MainCalenderScreen(viewModel: CalenderViewModel = CalenderViewModel()) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(16.dp)) {

        viewModel.selectedMonth.observeAsState().value?.let { DateView(it) }
        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            horizontalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            items(viewModel.list) {
                DayNameItem(it.name)
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            horizontalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            items(count = viewModel.dateList.size + viewModel.currentDayFfWeek) {
                if (it >= viewModel.currentDayFfWeek) {
                    var countDate = it - viewModel.currentDayFfWeek
                    DateItem(isCurrent = (it - (viewModel.currentDayFfWeek - 1)) == 16, ++countDate)
                }
            }
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
