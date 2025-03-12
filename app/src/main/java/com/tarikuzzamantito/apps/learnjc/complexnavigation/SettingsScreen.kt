package com.tarikuzzamantito.apps.learnjc.complexnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Tarikuzzaman on 3/11/2025 11:01 AM
 */


@Composable
fun SettingsScreen(
    navigateToHomeScreen: () -> Unit,
    navigateToProfileScreen: (Int, Boolean) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Settings Screen", fontSize = 30.sp)
        Button(onClick = {
            /* Navigate to Home Screen */
            navigateToHomeScreen()
        }) {
            Text(text = "Go to Home Screen")
        }
        Button(onClick = {
            /* Navigate to Profile Screen */
            navigateToProfileScreen(123, true)

        }) {
            Text(text = "Go to Profile Screen")
        }
    }
}