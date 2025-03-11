package com.tarikuzzamantito.apps.learnjc.complexnavigation

/**
 * Created by Tarikuzzaman on 3/11/2025 11:24 AM
 */

sealed class NavRoute(val path: String) {
    // Sealed Class: represent restricted hierarchies where a value can have one of the types form a limited set, but no other types.
    object Home : NavRoute("home")
    object Profile : NavRoute("profile") {
        val id = "id"
        val showDetails = "showDetails"
    }

    object Settings : NavRoute("settings")
}