package com.tarikuzzamantito.apps.learnjc.custom

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tarikuzzamantito.apps.learnjc.R

/**
 * Created by Tarikuzzaman on 3/7/2025 4:38 PM
 */

@Preview(showBackground = true)
@Composable
fun CallComposable() {
    Column {
        Challenge01("Android")
        DisplayImage()
        FilledButton(
            {
                Log.v("TAGY", "Button Clicked")
            }
        )
        FilledTonal {
            Log.v("TAGY", "Tonal Button Clicked")
        }
        ElevatedButtonExample {
            Log.v("TAGY", "Elevated Button Clicked")
        }
        OutlinedButtonExample {
            Log.v("TAGY", "Outlined Button Clicked")
        }
        TextButtonExample {
            Log.v("TAGY", "Text Button Clicked")
        }

        MyTextField()

        Counter()
    }
}


// State Management
/**
 * You should note that not all values will initiate a recomposition
 * when they change, only states can do that
 */
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    Column {
        Text(
            text = "The Counter: $count "
        )
        Button(onClick = {
            count++
            Log.v("TAGY", "Counter Value: $count")
        }) {
            Text("Increase Counter")
        }
    }
}

// TextField
@Composable
fun MyTextField() {
    var text by remember {
        mutableStateOf(TextFieldValue())
    }
    TextField(
        value = text,
        onValueChange = { newValue ->
            text = newValue
        },
        label = {
            Text("Enter your name")
        })
}

// Button Composable
// 1- Filled Button
@Composable
fun FilledButton(onClick: () -> Unit) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Click Me")
    }
}

// 2- Filled Tonal
@Composable
fun FilledTonal(onClick: () -> Unit) {
    FilledTonalButton(onClick = {
        onClick()
    }) {
        Text("Filled Tonal Button")
    }
}

// 3- Elevated Button
@Composable
fun ElevatedButtonExample(onClick: () -> Unit) {
    ElevatedButton(
        onClick = {
            onClick()
        },
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
    ) {
        Text("Elevated Button")
    }
}

// 4- Outlined Button
@Composable
fun OutlinedButtonExample(onClick: () -> Unit) {
    OutlinedButton(
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Red
        )
    ) {
        Text("Outlined Button")
    }
}

// 5- Text Button
@Composable
fun TextButtonExample(onClick: () -> Unit) {
    TextButton(onClick = {

    }) {
        Text("Text Button")
    }
}


@Composable
fun DisplayImage() {

    // load image from drawable resource
    val myPainter = painterResource(id = R.drawable.ideaapplogo)

    // Display the image with a content descriptions
    Image(
        painter = myPainter,
        contentDescription = "App Logo"
    )
}

@Composable
fun Challenge01(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .border(6.dp, color = Color.Red)
            .padding(16.dp)
            .border(2.dp, color = Color.Blue)
            .padding(4.dp)
    ) {
        Text(
            text = "Hello Learn Jetpack Compose",
            color = Color.Red,
            fontSize = 28.sp,
            modifier = Modifier.padding(start = 50.dp),
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Serif,
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.LineThrough,
                    TextDecoration.Underline
                )
            )
        )
        Text(
            text = "Download it from PlayStore",
            textDecoration = TextDecoration.Underline
        )

    }
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