package com.masum.custom_calender.main_file

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masum.custom_calender.component.DateItem
import com.masum.custom_calender.component.DateView
import com.masum.custom_calender.component.DayNameItem
import com.masum.mycalender.ui.theme.MycalenderTheme
import com.masum.mycalender.ui.theme.background


@Composable
fun MainCalenderScreen(
    viewModel: CalenderViewModel = CalenderViewModel(),
    selectedDate: MutableState<String>,
    ) {

    val selectedIndex = remember { mutableStateOf(viewModel.selectedExploreIndex.value!!) }

    LaunchedEffect(key1 = selectedIndex.value, block = {
        viewModel.selectedExploreIndex.value = selectedIndex.value
    })
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        viewModel.selectedMonth.observeAsState().value?.let {
            DateView(it,
                {
                    viewModel.decreaseMonth(it)
                    selectedIndex.value = -1
                },
                {
                    viewModel.increaseMonth(it)
                    selectedIndex.value = -1
                })
        }
        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(viewModel.list, key = { item -> item.name }) {
                DayNameItem(it.name)
            }
        }
        viewModel.calenderMonth.observeAsState().value?.let {
            LazyVerticalGrid(
                columns = GridCells.Fixed(7),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(items = it, key = { index, item -> index }) { index, item ->
                    if (item.date != -1) {
                        DateItem(monthDate = item, selectedIndex = selectedIndex) { item ->
                            selectedDate.value = item.actualDate ?: ""
                        }
                    }
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
         //   MainCalenderScreen()
        }
    }
}
