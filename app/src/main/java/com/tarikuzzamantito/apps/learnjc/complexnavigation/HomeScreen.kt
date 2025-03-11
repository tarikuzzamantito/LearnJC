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
 * Created by Tarikuzzaman on 3/11/2025 10:57 AM
 */

@Composable
fun HomeScreen(
    navigateToProfileScreen: (Int, Boolean) -> Unit,
    navigateToSettingsScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home Screen", fontSize = 40.sp)
        Button(onClick = {
            /* Navigate to Profile Screen */
            navigateToProfileScreen(123, true)
        }) {
            Text(text = "Go to Profile Screen")
        }
        Button(onClick = navigateToSettingsScreen) {
            Text(text = "Go to Settings Screen")
        }
    }
}