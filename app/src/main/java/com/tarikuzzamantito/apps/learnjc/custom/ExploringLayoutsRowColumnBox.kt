package com.tarikuzzamantito.apps.learnjc.custom

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tarikuzzamantito.apps.learnjc.R

/**
 * Created by Tarikuzzaman on 3/9/2025 2:40 PM
 * Exploring Layouts: Row, Column, Box, Surface, Scaffold
 */

/**
 * COLUMN - place items vertically on the screen
 *        - A vertical layout composable that places its children in a vertical sequence.
 * ROW - place items horizontally on the screen
 *     - A horizontal layout composable that places its children in a horizontal sequence.
 * BOX - put elements on top of another
 */

/** Notes: Arrangement: ROW: horizontalArrangement COLUMN: verticalArrangement
 * Arrangement: Arrangement is used to control the spacing of children in the main axis, so you will find
 *              in Column a verticalArrangement param and in Row a horizontalArrangement param.
 *
 * ROW -> horizontalArrangement
 * horizontalArrangement: Specifies the horizontal arrangement of items within the row.
 *      It can be set to Start, Center, End, SpaceEvenly, SpaceBetween, SpaceAround.
 *
 * COLUMN -> verticalArrangement
 * Column: verticalArrangement: Specifies the vertical arrangement of items within the column.
 *         It can be set to Top(default), Center, Bottom, SpaceEvenly, SpaceBetween, SpaceAround.
 */

/** Notes: Alignment: ROW: verticalAlignment COLUMN: horizontalAlignment
 * Alignment: The Alignment is used to control spacing of children in the cross axis,
 * so you will find in Column a horizontalAlignment param and in Row a verticalAlignment param.
 *
 * ROW -> verticalAlignment
 * verticalAlignment: Defines the vertical alignment of items within the row.
 *                    You can set it to Top, Center, Bottom.
 * horizontalAlignment: Defines the horizontal alignment of items within the column.
 *                     You can set it to Start, Center, End.
 */

// Layouts: Deep Dive
// 1- Exploring Layouts: Rows
@Composable
fun MyRow() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Welcome Back")
        Text("Download The App")
        Text("From PlayStore")
    }
}

// 2- Exploring Layouts: Columns
@Composable
fun MyColumn() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Welcome Back")
        Text("Download The App")
        Text("From PlayStore")
    }
}

// 3- Exploring Layouts: Boxes
@Composable
fun MyBox() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Welcome Back", modifier = Modifier.align(Alignment.TopStart))
        Text("Download The App", modifier = Modifier.align(Alignment.Center))
        Text("From PlayStore", modifier = Modifier.align(Alignment.BottomEnd))
    }
}

// 4- Exploring Layouts: Surface
// holds one child at a time
// provides many style treatments for its children
@Composable
fun MySurface() {
    Surface(
        modifier = Modifier.size(100.dp),
        color = colorResource(id = R.color.purple_200),
        contentColor = Color.Black,
        shadowElevation = 1.dp,
        border = BorderStroke(2.dp, colorResource(R.color.purple_700)),
    ) {
        MyColumn()
    }
}

// 5- Exploring Layouts: Scaffold [Scaffold acts as a foundational layout structure for your app]
/** Notes: Scaffold: Scaffold is a layout composable that provides a material design scaffold for your app.
 *  It provides a layout structure for the top app bar, bottom app bar, floating action button, and more.
 *  SCAFFOLD: Scaffold acts as a foundational structure for Compose UIs,
 *  providing a layout that includes essential components like the TopAppBar, BottomAppBar, and FloatingActionButton.
 *
 *  Its primary purpose is to streamline the development process by offering a standardized layout
 *  that can be easily customized to fit your app's design.
 */
// Scaffold is a layout composable that provides a material design scaffold for your app.
// It provides a layout structure for the top app bar, bottom app bar, floating action button, and more.

/** Notes: Components of Scaffold Layout
 * TopAppBar: Positioned at the top of the UI, it often contains the app's title, navigation actions, and other relevant items.
 * A material design app bar that displays the app's title, navigation icon, and actions.
 *
 * BottomAppBar: Placed at the bottom, it typically houses navigation icons and other contextual actions.
 * FloatingActionButton: A floating circular button for primary user actions, s
 * uch as adding a new item or navigating to a critical section of the app.
 */
// Scaffold: provides a layout that includes essential components like
// TopAppBar, BottomAppBar, and FloatingActionButton.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Scaffold Top App Title") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation icon click */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle action click */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
                    }
                }
            )
        },
        bottomBar = { BottomAppBar(containerColor = Color.Red) {} },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) { }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        MyColumn()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(context: Context) {
    TopAppBar(
        title = { Text(text = "TopAppBar Title") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.purple_700),
            titleContentColor = colorResource(R.color.white),
        ),
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(context, "Clicked the Nav Icon", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = colorResource(id = R.color.white)
                )
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Clicked the Settings Icon", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_settings_24),
                    contentDescription = "Settings",
                    tint = colorResource(id = R.color.white)
                )
            }
        }
    )
}

@Composable
fun MyBottomAppBar(context: Context) {
    BottomAppBar(
        containerColor = Color.DarkGray,
        contentColor = Color.White,
    ) {
        // BottomAppBar content
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            IconButton(onClick = {
                Toast.makeText(context, "Clicked Home Icon", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_home_24),
                    contentDescription = "Home",
                    tint = colorResource(id = R.color.white)
                )
            }
            IconButton(onClick = {
                Toast.makeText(context, "Clicked Collections Bookbar Icon", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_collections_bookmark_24),
                    contentDescription = "Collections Bookmark",
                    tint = colorResource(id = R.color.white)
                )
            }
            IconButton(onClick = {
                Toast.makeText(context, "Clicked Profile Icon", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_people_24),
                    contentDescription = "Profile",
                    tint = colorResource(id = R.color.white)
                )
            }
        }
    }
}

@Composable
fun MyFloatingActionButton(context: Context) {
    FloatingActionButton(
        onClick = {
            Toast.makeText(context, "Clicked Profile Icon", Toast.LENGTH_SHORT).show()
        },
        containerColor = Color.Magenta,
        contentColor = Color.White
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_add_24),
            contentDescription = "Add Note",
            tint = colorResource(id = R.color.white)
        )
    }
}