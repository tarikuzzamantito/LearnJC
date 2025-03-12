package com.tarikuzzamantito.apps.learnjc.complexnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.tarikuzzamantito.apps.learnjc.complexnavigation.navigate.BottomNavigationBar
import com.tarikuzzamantito.apps.learnjc.complexnavigation.navigate.NavGraph
import com.tarikuzzamantito.apps.learnjc.ui.theme.LearnJCTheme

class ComplexNavigationAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            LearnJCTheme {
                Surface(color = Color.White) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navController = navController)
                        }
                    ) { padding ->

                        NavGraph(navController)
                    }
                }
            }
        }

    }
}