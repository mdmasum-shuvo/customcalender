

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.masum.custom_calender.ui.theme.brand_color

@RequiresApi(Build.VERSION_CODES.O)
fun Modifier.drawColoredShadow(
    color: Color = brand_color,
    alpha: Float = 0.2f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 2.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)  this.drawBehind {
    val transparentColor = android.graphics.Color.toArgb(color.copy(alpha = 0.0f).value.toLong())
    val shadowColor = android.graphics.Color.toArgb(color.copy(alpha = alpha).value.toLong())
    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadowRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            borderRadius.toPx(),
            borderRadius.toPx(),
            paint
        )
    }
}
else {
    Modifier
}

@Composable
fun cardColor(color: Color) =
    cardColors(
        containerColor = color,
    )



