package com.tarikuzzamantito.apps.learnjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.tarikuzzamantito.apps.learnjc.custom.MyBottomAppBar
import com.tarikuzzamantito.apps.learnjc.custom.MyCard
import com.tarikuzzamantito.apps.learnjc.custom.MyColumn
import com.tarikuzzamantito.apps.learnjc.custom.MyFloatingActionButton
import com.tarikuzzamantito.apps.learnjc.custom.MyGrid
import com.tarikuzzamantito.apps.learnjc.custom.MyLazyColumn
import com.tarikuzzamantito.apps.learnjc.custom.MySurface
import com.tarikuzzamantito.apps.learnjc.custom.MyTopAppBar
import com.tarikuzzamantito.apps.learnjc.custom.ScrollingColumn
import com.tarikuzzamantito.apps.learnjc.custom.ScrollingRow
import com.tarikuzzamantito.apps.learnjc.ui.theme.LearnJCTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnJCTheme {
                Scaffold(
                    topBar = { MyTopAppBar(this) },
                    bottomBar = { MyBottomAppBar(this) },
                    floatingActionButton = {
                        MyFloatingActionButton(context = this)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    val modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(innerPadding)
                    MyGrid(this)
                }

            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        LearnJCTheme {
            Column {

            }
        }
    }
}