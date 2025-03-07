package com.tarikuzzamantito.apps.learnjc.custom

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by Tarikuzzaman on 3/7/2025 4:38 PM
 */

@Preview(showBackground = true)
@Composable
fun CallComposable() {
    Greeting("Android")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        color = Color.Red,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.Cursive,
        textDecoration = TextDecoration.combine(
            listOf(
                TextDecoration.LineThrough,
                TextDecoration.Underline
            )
        ),
        textAlign = TextAlign.Center,
        modifier = modifier,
    )
}