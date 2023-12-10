package com.masum.mycalender.customer_calender.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masum.mycalender.ui.theme.MycalenderTheme
import com.masum.mycalender.ui.theme.background
import com.masum.mycalender.ui.theme.light_background

@Composable
fun DateItem() {
    Card(modifier = Modifier.wrapContentSize(),
        shape = RoundedCornerShape(4.dp),
        colors = cardColor(light_background)
    ) {
        Column (modifier = Modifier.padding(12.dp)){
            Text(text = "10", style = MaterialTheme.typography.titleMedium, )
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
        Surface (color = background){
            DateItem()

        }
    }
}


