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
 * Created by Tarikuzzaman on 3/11/2025 10:58 AM
 */

@Composable
fun ProfileScreen(
    id: Int,
    showDetails: Boolean,
    navigateToSettingsScreen: () -> Unit,
    navigateToHomeScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Profile Screen")
        Text(text = "Profile ID: $id", fontSize = 40.sp)
        Text(text = "Show Details: $showDetails", fontSize = 40.sp)

        Button(onClick = {
            /* Navigate to Settings Screen */
            navigateToSettingsScreen()
        }) {
            Text(text = "Go to Settings Screen")
        }
        Button(onClick = {
            /* Navigate to Home Screen */
            navigateToHomeScreen()
        }) {
            Text(text = "Go to Home Screen")
        }
    }
}