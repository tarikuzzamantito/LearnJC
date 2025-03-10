package com.tarikuzzamantito.apps.learnjc.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tarikuzzamantito.apps.learnjc.R
import com.tarikuzzamantito.apps.learnjc.ui.theme.LearnJCTheme

class NavigationAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // 1- NavController: Navigation between composable functions
            val navController = rememberNavController()

            // 2- NavHost: Defines the nav Graph, start & composable destinations
            NavHost(
                navController = navController,
                startDestination = "first_screen"
            ) {
                composable(route = "first_screen") { FirstScreen(navController) }
                composable(
                    route = "second_screen/{name}?age={age}",
                    arguments = listOf(
                        // 2- passing a list of named nav args
                        navArgument("name") { type = NavType.StringType },
                        navArgument("age") {
                            type = NavType.StringType
                            defaultValue = "30"
                            nullable = true
                        },
                    )
                ) { backStackEntry ->
                    SecondScreen(
                        navController,
                        backStackEntry.arguments?.getString("name").toString(),
                        backStackEntry.arguments?.getString("age").toString()
                    )
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController) {
    Column(modifier = Modifier.padding(40.dp)) {
        Text(text = "This is the First Screen")

        var enteredName by remember { mutableStateOf("") }
        TextField(
            value = enteredName,
            onValueChange = { enteredName = it },
            label = { Text(text = "Enter your name") }
        )
        var enteredAge by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.padding(10.dp))
        TextField(
            value = enteredAge,
            onValueChange = { enteredAge = it },
            label = { Text(text = "Enter your age") }
        )

        Button(onClick = {
            // 1- Passing the entered name as argument
            navController.navigate(route = "second_screen/${enteredName}?age=${enteredAge}")
        }) {
            Text(text = "Go to Second Screen")
        }
    }
}

@Composable
fun SecondScreen(navController: NavController, name: String, age: String) {
    Column(modifier = Modifier.padding(40.dp)) {
        Text(text = "This is the Second Screen")
        Text(text = "Welcome $name, Your age is $age")
        Button(onClick = {
            //navController.navigate(route = "first_screen")
            navController.navigateUp()
        }) {
            Text(text = "Go to First Screen")
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_10)
@Composable
fun NavigationAppScreenPreview() {
    LearnJCTheme {

    }
}