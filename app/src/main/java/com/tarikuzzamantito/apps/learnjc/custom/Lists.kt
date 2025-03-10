package com.tarikuzzamantito.apps.learnjc.custom

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tarikuzzamantito.apps.learnjc.R

/**
 * Created by Tarikuzzaman on 3/9/2025 11:27 PM
 */

@Composable
fun MyGrid(context: Context) {
    val itemsList = listOf<String>(
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 5",
        "Item 6",
        "Item 7",
        "Item 8",
        "Item 9",
        "Item 10",
        "Item 11",
        "Item 12",
        "Item 13",
        "Item 14",
        "Item 15"
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize()
    ) {
        items(itemsList.size) { index ->
            MyCustomItem(itemTitle = itemsList[index], context)
        }
    }

}

// Card Composable: displays content in cards
@Composable
fun MyCard(modifier: Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .padding(16.dp),
        colors = CardDefaults.cardColors(Color.Gray),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Text(text = "This is a simple Card", modifier = Modifier.padding(16.dp))
        Text(text = "This is a simple Card", modifier = Modifier.padding(16.dp))
        Text(text = "This is a simple Card", modifier = Modifier.padding(16.dp))
    }
}


@Composable
fun MyLazyRow(context: Context) {
    val itemsList = listOf<String>("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    LazyRow {
        items(itemsList.size) { index ->
            MyCustomItem(itemsList[index], context)
        }
    }
}

@Composable
fun MyCustomItem(itemTitle: String, context: Context) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                // Handle the click events
                Toast.makeText(context, "Clicked $itemTitle", Toast.LENGTH_SHORT).show()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = itemTitle,
            fontSize = 42.sp,
            modifier = Modifier
                .background(color = Color.Gray)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onLongPress = {
                            Toast.makeText(context, "Long Pressed $itemTitle", Toast.LENGTH_SHORT)
                                .show()
                        },
                        onDoubleTap = {
                            Toast.makeText(context, "Double Tapped $itemTitle", Toast.LENGTH_SHORT)
                                .show()
                        },
                        onTap = {
                            Toast.makeText(
                                context,
                                "Normal Pressed on $itemTitle",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyLazyColumn(context: Context) {
    val itemsList = listOf<String>(
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 5",
        "Item 6",
        "Item 7",
        "Item 8",
        "Item 9",
        "Item 10",
        "Item 11",
        "Item 12",
        "Item 13",
        "Item 14",
        "Item 15S"
    )
    LazyColumn {
        stickyHeader {
            Text(
                text = "Sticky Header",
                fontSize = 42.sp,
                modifier = Modifier.background(Color.Red)
            )
        }
        item {
            Text(text = "Title for Items", fontSize = 40.sp)
            Text(text = "Title for Items", fontSize = 40.sp)
            Text(text = "Title for Items", fontSize = 40.sp)
        }
        items(itemsList.size) { index ->
            MyCustomItem(itemsList[index], context)
        }
    }
}

@Composable
fun ScrollingColumn() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.pic1),
            contentDescription = "Pic 1",
            contentScale = ContentScale.FillBounds
        )
        Image(
            painter = painterResource(id = R.drawable.pic2),
            contentDescription = "Pic 2",
            contentScale = ContentScale.FillBounds
        )
        Image(
            painter = painterResource(id = R.drawable.pic1),
            contentDescription = "Pic 3",
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun ScrollingRow() {
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.pic1),
            contentDescription = "Pic 1",
            contentScale = ContentScale.FillBounds
        )
        Image(
            painter = painterResource(id = R.drawable.pic2),
            contentDescription = "Pic 2",
            contentScale = ContentScale.FillBounds
        )
        Image(
            painter = painterResource(id = R.drawable.pic1),
            contentDescription = "Pic 3",
            contentScale = ContentScale.FillBounds
        )
    }
}