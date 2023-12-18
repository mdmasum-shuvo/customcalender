package com.masum.custom_calender.component

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masum.custom_calender.data.MonthDate
import com.masum.mycalender.ui.theme.MycalenderTheme
import com.masum.mycalender.ui.theme.background
import com.masum.mycalender.ui.theme.brand_color
import com.masum.mycalender.ui.theme.greenColor
import com.masum.mycalender.ui.theme.lightGreenColor
import com.masum.mycalender.ui.theme.light_background
import com.masum.mycalender.ui.theme.light_green

@Composable
fun DateItem(
    monthDate: MonthDate?,
    selectedIndex: MutableState<Int>? = null,
    onClick: (monthDate: MonthDate) -> Unit = { }
) {
    Log.e("data", monthDate.toString())
    Box(
        modifier = Modifier
            .padding(vertical = 4.dp)
    ) {
        Card(
            Modifier
                .fillMaxWidth()
                .selectable(
                    selected = selectedIndex?.value == monthDate?.date, onClick = {
                        selectedIndex?.value =
                            if (selectedIndex?.value != monthDate?.date) monthDate?.date!! else -1
                        if (monthDate != null) {
                            onClick(monthDate)
                        }
                    })
                .height(48.dp),
            border = BorderStroke(
                1.dp,
                if (monthDate?.isCurrent == true) greenColor else light_background
            ),
            shape = RoundedCornerShape(8.dp),
            //  elevation = CardDefaults.cardElevation(2.dp),
        ) {
            Box(
                modifier = Modifier.background(
                    brush = Brush.horizontalGradient(
                        colors = if (selectedIndex?.value == monthDate?.date) listOf(
                            lightGreenColor,
                            greenColor,
                            greenColor,
                            greenColor,
                        ) else listOf(
                            light_background,
                            light_background
                        )
                    )
                )

            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = monthDate?.date.toString(),
                        style = MaterialTheme.typography.titleMedium,
                        color = if (selectedIndex?.value == monthDate?.date) light_background else Color.Black,
                    )
                    if (monthDate?.isHasEvent == true) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(8.dp)
                                .background(if (selectedIndex?.value == monthDate?.date) light_background else greenColor)
                        )
                    }

                }
            }

        }


    }
}

@Composable
fun cardColor(color: Color) =
    CardDefaults.cardColors(
        containerColor = color,
    )

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DateItemPreview() {
    MycalenderTheme {
        Surface(color = background) {
            //DateItem()

        }
    }
}


