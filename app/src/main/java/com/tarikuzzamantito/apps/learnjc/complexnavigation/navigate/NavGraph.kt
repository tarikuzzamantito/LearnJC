package com.tarikuzzamantito.apps.learnjc.complexnavigation.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tarikuzzamantito.apps.learnjc.complexnavigation.HomeScreen
import com.tarikuzzamantito.apps.learnjc.complexnavigation.ProfileScreen
import com.tarikuzzamantito.apps.learnjc.complexnavigation.SettingsScreen

/**
 * Created by Tarikuzzaman on 3/11/2025 11:04 AM
 */

@Composable
fun NavGraph(navController: NavHostController) {

    // Use navController to navigate to different composables defined in the nav graph
    // Nav Host: acts as a container for hosting the Nav Graph
    NavHost(
        navController = navController,
        startDestination = NavRoute.Home.path
    ) {
        addHomeScreen(navController, this)

        addProfileScreen(navController, this)

        addSettingsScreen(navController, this)
    }

}

fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    // navGraphBuilder: define the composables route for the HomeScreen
    navGraphBuilder.composable(
        route = NavRoute.Home.path // "home"
    ) {
        HomeScreen(
            navigateToProfileScreen = { id, showDetails ->
                navController.navigate(
                    //"${NavRoute.Profile.path}?${NavRoute.Profile.id}=$id&${NavRoute.Profile.showDetails}=$showDetails"
                    //"home/id/showDetails"
                    //NavRoute.Profile.path.plus(id.toString()).plus(showDetails.toString())

                    //NavRoute.Profile.path.plus("/$id/$showDetails")
                    NavRoute.Profile.createRoute(123, false)

                )
            },
            navigateToSettingsScreen = {
                navController.navigate(NavRoute.Settings.path)
            }
        )
    }
}

fun addProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.path.plus("/{id}/{showDetails}"),
        arguments = listOf(
            navArgument("id") {
                type = NavType.IntType
            },
            navArgument("showDetails") {
                type = NavType.BoolType
            }
        )
    ) { navBackStackEntry ->
        val args = navBackStackEntry.arguments
        ProfileScreen(
            id = args?.getInt("id")!!,
            showDetails = args.getBoolean("showDetails"),
            navigateToSettingsScreen = { navController.navigate(NavRoute.Settings.path) },
            navigateToHomeScreen = { navController.navigate("home") },
        )
    }
}

fun addSettingsScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Settings.path
    ) {
        SettingsScreen(
            navigateToHomeScreen = { navController.navigate(NavRoute.Home.path) },
            navigateToProfileScreen = { id, showDetails ->
                navController.navigate(
                    NavRoute.Profile.path.plus("/$id/$showDetails")
                )
            },
        )
    }
}