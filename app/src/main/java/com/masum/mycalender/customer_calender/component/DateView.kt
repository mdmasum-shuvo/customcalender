package com.masum.mycalender.customer_calender.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.masum.mycalender.ui.theme.MycalenderTheme
import com.masum.mycalender.ui.theme.background


@Composable
fun DateView(
    selectedDate: String = "OCT 2023",
    onLeftClick: () -> Unit,
    onRightClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            Icons.Default.KeyboardArrowLeft,
            contentDescription = "",
            modifier = Modifier.clickable { onLeftClick() })
        Text(
            text = selectedDate,
            style = MaterialTheme.typography.headlineLarge,
        )
        Icon(
            Icons.Default.KeyboardArrowRight,
            contentDescription = "",
            modifier = Modifier.clickable { onRightClick() })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DateViewPreview() {
    MycalenderTheme {
        Surface(color = background) {
            DateView("",{},{})
        }
    }
}
