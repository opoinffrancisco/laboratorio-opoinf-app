package com.opoinf.laboratorio_opoinf.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),
    onPrimary = Color.Black,
    primaryContainer = Color(0xFF3700B3),
    onPrimaryContainer = Color.White,
    secondary = Color(0xFF03DAC5),
    onSecondary = Color.Black,
    secondaryContainer = Color(0xFF018786),
    onSecondaryContainer = Color.White,
    tertiary = Color(0xFFFF9800),
    onTertiary = Color.Black,
    tertiaryContainer = Color(0xFFFF5722),
    onTertiaryContainer = Color.White,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF121212),
    onSurface = Color.White,
    error = Color(0xFFCF6679),
    onError = Color.Black,
    errorContainer = Color(0xFFB00020),
    onErrorContainer = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF3700B3),
    onPrimaryContainer = Color.White,
    secondary = Color(0xFF03DAC5),
    onSecondary = Color.Black,
    secondaryContainer = Color(0xFF018786),
    onSecondaryContainer = Color.White,
    tertiary = Color(0xFFFF9800),
    onTertiary = Color.Black,
    tertiaryContainer = Color(0xFFFF5722),
    onTertiaryContainer = Color.White,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color(0xFFB00020),
    onError = Color.White,
    errorContainer = Color(0xFFCF6679),
    onErrorContainer = Color.Black
)

@Composable
fun LaboratorioOpoinfTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
