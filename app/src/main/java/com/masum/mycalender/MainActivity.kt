package com.masum.mycalender

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.masum.custom_calender.main_file.CalenderViewModel
import com.masum.custom_calender.main_file.MainCalenderScreen

import com.masum.custom_calender.ui.theme.MycalenderTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: CalenderViewModel = ViewModelProvider(this)[CalenderViewModel::class.java]
        val eventList = ArrayList<String>()


        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                val selectedDate = remember {
                    mutableStateOf("")
                }
                eventList.add("01/12/2023")
                eventList.add("09/12/2023")
                eventList.add("10/12/2023")
                eventList.add("11/12/2023")
                eventList.add("12/12/2023")
                eventList.add("17/12/2023")
                eventList.add("30/12/2023")
                eventList.add("27/12/2023")
                eventList.add("27/11/2023")
                viewModel.createEvent(eventList)
                viewModel.generateCalender()

                LaunchedEffect(key1 = selectedDate.value, block = {
                    //do here
                    Log.e("selected date", "select date:" + selectedDate.value)
                })
                MainCalenderScreen(viewModel, selectedDate = selectedDate)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MycalenderTheme {
        Greeting("Android")
    }
}