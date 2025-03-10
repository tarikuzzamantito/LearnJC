package com.tarikuzzamantito.apps.learnjc.groceryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tarikuzzamantito.apps.learnjc.R
import com.tarikuzzamantito.apps.learnjc.ui.theme.LearnJCTheme

class GroceryAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LazyColumnWithStickyHeader()
        }
    }

}

@Preview(showBackground = true, device = Devices.NEXUS_10)
@Composable
fun GroceryAppPreview() {
    LearnJCTheme {
        val item1 = GroceryItem(
            title = "Apple",
            desc = "This is an Apple, a fruit, a very healthy food",
            image = R.drawable.ideaapplogo
        )
        GroceryCardItem(item1)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnWithStickyHeader() {
    // 1- Creating the Data Source: Map with key-value pairs
    val groupedItems = mapOf(
        "Fruits" to listOf(
            GroceryItem("Apple", "A sweet red fruit", R.drawable.apple),
            GroceryItem("Banana", "A long yellow fruit", R.drawable.banana),
            GroceryItem("Cherry", "A small red fruit", R.drawable.cherries),
            GroceryItem("Mango", "A delicious fruit", R.drawable.mango),
            GroceryItem("WaterMelon", "A big an sweet fruit", R.drawable.watermelon),
            GroceryItem("Grapes", "A small and testy fruit", R.drawable.grapes),
        ),
        "Vegetables" to listOf(
            GroceryItem("Carrot", "A long orange vegetable", R.drawable.carrots),
            GroceryItem("Lettuce", "A leafy green vegetable", R.drawable.lettuce),
            GroceryItem("Broccoli", "A beautiful Vegetable", R.drawable.broccoli),
            GroceryItem("Onion", "Amazing Vegetable", R.drawable.onion),
            GroceryItem("Potato", "yellow vegetable", R.drawable.potatoes),
            GroceryItem("Tomato", "A red and sweet vegetable", R.drawable.tomatoes),
            GroceryItem("Pea", "Sweet Vegetable", R.drawable.pea)
        )
    )
    val myFruits =
        groupedItems["Fruits"] // ["Apple", "Banana","Cherry","Mango","WaterMelon","Grapes"]

    // 2- Lazy Column
    LazyColumn {
        groupedItems.forEach { (header, items) ->
            stickyHeader {
                GroceryHeader(title = header)
            }
            items(items) { item ->
                GroceryCardItem(item)
            }
        }
    }
}

@Composable
fun GroceryHeader(title: String) {
    Text(
        text = title,
        fontSize = 32.sp,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .padding(8.dp)
    )
}

@Composable
fun GroceryCardItem(item: GroceryItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Grocery Item Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            // Adding Space between UI Elements
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = item.title, fontSize = 24.sp, color = colorResource(R.color.blackish))

            Spacer(modifier = Modifier.height(4.dp))
            Text(text = item.desc, fontSize = 18.sp, color = colorResource(R.color.blackish))

        }
    }
}