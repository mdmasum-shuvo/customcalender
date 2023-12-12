package com.masum.mycalender.customer_calender.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masum.mycalender.ui.theme.MycalenderTheme
import com.masum.mycalender.ui.theme.background
import com.masum.mycalender.ui.theme.brand_color
import com.masum.mycalender.ui.theme.circleColor
import com.masum.mycalender.ui.theme.green
import com.masum.mycalender.ui.theme.light_background

@Composable
fun DateItem(
    isCurrent: Boolean = false,
    dateNumber: Int = 0,
    selectedIndex: MutableState<Int>? = null,
    onClick: (Int) -> Unit = { }
) {
    Box(modifier = Modifier.padding(vertical = 4.dp)) {
        Card(
            Modifier
                .fillMaxWidth()
                .selectable(
                    selected = selectedIndex?.value == dateNumber, onClick = {
                        selectedIndex?.value =
                            if (selectedIndex?.value != dateNumber) dateNumber else -1
                        onClick(0)
                    })
                .height(48.dp),
            shape = RoundedCornerShape(4.dp),
            //  elevation = CardDefaults.cardElevation(2.dp),
            colors = cardColor(if (isCurrent) green else if (selectedIndex?.value == dateNumber) brand_color else light_background)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = dateNumber.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    color = if (isCurrent) light_background else if (selectedIndex?.value == dateNumber) light_background else Color.Black,
                )
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(8.dp)
                        .background(circleColor)

                )
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
            DateItem()

        }
    }
}


