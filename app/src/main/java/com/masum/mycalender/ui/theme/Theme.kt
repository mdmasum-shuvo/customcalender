package com.masum.mycalender.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.masum.custom_calender.ui.theme.Pink
import com.masum.custom_calender.ui.theme.background
import com.masum.custom_calender.ui.theme.blue
import com.masum.custom_calender.ui.theme.blue_bg
import com.masum.custom_calender.ui.theme.brand_color
import com.masum.custom_calender.ui.theme.card_yellow
import com.masum.custom_calender.ui.theme.dark_background
import com.masum.custom_calender.ui.theme.gray_bg
import com.masum.custom_calender.ui.theme.light_background
import com.masum.custom_calender.ui.theme.light_blue
import com.masum.custom_calender.ui.theme.light_green
import com.masum.custom_calender.ui.theme.off_white
import com.masum.custom_calender.ui.theme.text_dark
import com.masum.custom_calender.ui.theme.text_gray


private val DarkColorScheme = darkColorScheme(
    primary = light_background,
    secondary = text_gray,
    tertiary = text_dark,
    background = background,
    onPrimary = light_blue,
    onSecondary = brand_color,
    onBackground = gray_bg,
    primaryContainer = card_yellow,
    onPrimaryContainer = blue_bg,
    inversePrimary = light_green,
    scrim = blue,
    onTertiary = text_gray,
    secondaryContainer = dark_background,
    surface = Pink
)

private val LightColorScheme = lightColorScheme(
    primary = light_background,
    secondary = text_gray,
    tertiary = text_dark,
    background = background,
    onPrimary = light_blue,
    onSecondary = brand_color,
    onBackground = gray_bg,
    primaryContainer = card_yellow,
    onPrimaryContainer = blue_bg,
    inversePrimary = light_green,
    scrim = blue,
    onTertiary = text_gray,
    secondaryContainer = dark_background,
    surface = Pink,
    onSurface = off_white,

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun MycalenderTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}