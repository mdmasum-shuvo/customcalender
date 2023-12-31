package com.masum.custom_calender.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masum.custom_calender.ui.theme.MycalenderTheme
import com.masum.custom_calender.ui.theme.background
import com.masum.custom_calender.ui.theme.light_background


@Composable
fun DayNameItem(dayName: String = "10") {
    Box(modifier = Modifier.padding(vertical = 4.dp)) {
        Card(
            Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(4.dp),
            colors = cardColor(light_background)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = dayName,
                    style = MaterialTheme.typography.titleMedium,

                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DayNameItemPreview() {
    MycalenderTheme {
        Surface(color = background) {
            DayNameItem()
        }
    }
}
