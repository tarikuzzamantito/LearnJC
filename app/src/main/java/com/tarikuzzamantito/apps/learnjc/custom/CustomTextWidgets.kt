package com.tarikuzzamantito.apps.learnjc.custom

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
        StatefulCounter()
        StatefulTextField()
        // Stateful to Stateless 
        var text by remember { mutableStateOf("") }
        StatelessTextField(text = text, onValueChange = { newText ->
            text = newText
        })

        // Call Challenge 2
        var progress by remember { mutableStateOf(0.0f) }
        Column(verticalArrangement = Arrangement.Center) {
            LinearProgInd(progress = progress)

            IncreaseProgressButton {
                progress += 0.1f
                if (progress > 1.0f) {
                    // Reset the progress
                    progress = 0.0f
                }
            }

            ProgressText(progress = progress)
        }

    }
}


/** Coding Challenge 2
 * Create 3 Composables
 * 1- Linear Progress Indicator:
 * 2- Button: allows the user to increase the progress when being clicked
 * 3- Text: Displaying the Progress
 *
 * Note: All these Composables should be stateless
 */
@Composable
fun LinearProgInd(progress: Float) {
    LinearProgressIndicator(progress = { progress })
}

@Composable
fun IncreaseProgressButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Increase Progress")
    }
}

@Composable
fun ProgressText(progress: Float) {
    Text("The Progress is: $progress")
}
// ===============================================


// 5- Progress Indicator: Represents the progress of a task
// Circular Progress Indicator
@Composable
fun CircularProgInd() {
    CircularProgressIndicator()
    CircularProgressIndicator(progress = { 0.8f })
}

// Linear Progress Indicator
@Composable
fun LinearProInd() {
    LinearProgressIndicator()
    LinearProgressIndicator(progress = { 0.7f }, color = Color.Green, trackColor = Color.Gray)
}
// Determinate Progress Indicator
//--------------------------------

// Radio Button: users can select only one option from a list of options.
@Composable
fun RadioButtonExample() {
    // 1- Tracking the currently selected option
    var selectedOption by remember { mutableStateOf("Option 1") }

    // 2- The Radio Buttons
    Column {
        RadioButtonRow(
            text = "Option 1",
            selectedOption == "Option 1",
            onSelected = { selectedOption = "Option 1" },
        )
        RadioButtonRow(
            text = "Option 2",
            selectedOption == "Option 2",
            onSelected = { selectedOption = "Option 2" },
        )
        RadioButtonRow(
            text = "Option 3",
            selectedOption == "Option 3",
            onSelected = { selectedOption = "Option 3" },
        )
    }
}

// 4- Displaying a text beside Radio Button
@Composable
fun RadioButtonRow(text: String, isSelected: Boolean, onSelected: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = isSelected,
            onClick = onSelected,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Text(text = text)
    }
}


// Switch: allows users to toggle between two states, such as on/off or true/false.
// Switch: designed specifically for binary on/off choices- it is a two-state control.
@Composable
fun SwitchExample(context: Context) {
    // 1- Declare a mutable state variable to hold the checked state of the switch
    // Tracking checked/unchecked state of the Switch
    var isChecked by remember { mutableStateOf(false) }

    // 2- Create a Switch composable and pass the checked state to it
    Switch(
        checked = isChecked,
        onCheckedChange = {
            isChecked = it
            Toast.makeText(
                context,
                "Is Switch Checked: $isChecked",
                Toast.LENGTH_SHORT
            ).show()
        },
    )
}

// CheckBox: allows users to toggle between 2 states, allows users to select multiple options from a list of options.
@Composable
fun CheckBoxExample(context: Context) {
    // 1- Declare a mutable state variable to hold the checked state of the checkbox
    // Tracking checked/unchecked state of the checkbox
    var checked by remember { mutableStateOf(false) }

    // 2- Create a Checkbox composable and pass the checked state to it
    Checkbox(
        checked = checked,
        onCheckedChange = { isChecked ->
            checked = isChecked
            Toast.makeText(
                context,
                "Is CheckBox Checked: $isChecked",
                Toast.LENGTH_SHORT
            ).show()
        },
    )
}

// Stateful Composable: Manages its own State
@Composable
fun StatefulTextField() {
    var text by remember { mutableStateOf("") }
    Column {
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            label = { Text(text = "Enter Text") }
        )
        Text(text = "You Typed: $text")
    }
}

// Stateless Composable: Stateful to Stateless Composable
@Composable
fun StatelessTextField(
    text: String,
    onValueChange: (String) -> Unit
) {
    Column {
        TextField(
            value = text,
            onValueChange = onValueChange,
            label = { Text(text = "Enter Text") }
        )
        Text(text = "You Typed: $text")
    }
}

// Stateful Composable: Manages its own State
@Composable
fun StatefulCounter() {
    var count by remember { mutableStateOf(0) }
    Button(onClick = { count++ }) {
        Text("Clicked: $count times")
    }
}

// Stateless Composable
@Composable
fun StatelessCounter(count: Int, onClick: () -> Unit) {
    var count by remember { mutableStateOf(0) }
    Button(onClick = onClick) {
        Text("Clicked: $count times")
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