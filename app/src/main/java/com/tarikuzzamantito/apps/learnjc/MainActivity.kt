package com.tarikuzzamantito.apps.learnjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tarikuzzamantito.apps.learnjc.delegateim.NetworkStateHandler
import com.tarikuzzamantito.apps.learnjc.delegateim.NetworkStateListener
import com.tarikuzzamantito.apps.learnjc.ui.theme.LearnJCTheme

class MainActivity : ComponentActivity(), NetworkStateListener by NetworkStateHandler() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /*LearnJCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }*/
        }
        observeNetworkState(this, this)
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