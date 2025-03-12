package com.tarikuzzamantito.apps.learnjc.complexnavigation.navigate

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * Created by Tarikuzzaman on 3/11/2025 2:25 PM
 */

@Composable
fun BottomNavigationBar(navController: NavController) {

    // 1- The Items of Bottom Nav Bar
    val navItems = listOf(NavItem.Home, NavItem.Profile, NavItem.Settings)


    // Synchronization between NavigationBar and Current Screen
    // 3- Observing the current back stack entry
    val navBackStackEntity by navController.currentBackStackEntryAsState()

    // 4- Current Route
    val currentRoute = navBackStackEntity?.destination?.route

    // 2- Create a state variable that persists across recompositions
    //var selectedItem by rememberSaveable { mutableStateOf(0) }
    var selectedItem = navItems.indexOfFirst { it.path == currentRoute }
    var selectedNavItem by rememberSaveable { mutableStateOf(if (selectedItem >= 0) selectedItem else 0) }


    //3- Navigation bar
    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedNavItem = index

                    // Handling the navigation to the Profile Screen
                    // Passing Arguments between the screens
                    val route = if (item.path == NavRoute.Profile.path) {
                        NavRoute.Profile.path.plus("/123/true")
                    } else {
                        item.path
                    }

                    navController.navigate(route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(item.title) }

            )
        }
    }
}