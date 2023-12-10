package com.masum.mycalender.customer_calender.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masum.mycalender.ui.theme.MycalenderTheme
import com.masum.mycalender.ui.theme.background
import com.masum.mycalender.ui.theme.green
import com.masum.mycalender.ui.theme.light_background

@Composable
fun DateItem(isCurrent:Boolean=false,dateNumber:Int=0) {
    Box(modifier = Modifier.padding(vertical = 4.dp)) {
        Card(
            Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(4.dp),
            colors = cardColor(if (isCurrent) green else light_background)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text =dateNumber.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    color=if (isCurrent) light_background else Color.Black,
                    modifier = Modifier.align(alignment = Alignment.Center)
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


