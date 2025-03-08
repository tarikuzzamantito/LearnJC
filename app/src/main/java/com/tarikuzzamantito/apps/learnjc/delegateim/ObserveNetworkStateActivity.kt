package com.tarikuzzamantito.apps.learnjc.delegateim

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tarikuzzamantito.apps.learnjc.R

/**
 * Created by Tarikuzzaman on 3/8/2025 12:47 PM
 */
/**
 * Observe Network State with the help of implementing Delegation NetworkStateHandler
 */
class ObserveNetworkStateActivity : AppCompatActivity(),
    NetworkStateListener by NetworkStateHandler() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()
            ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { _, insets ->
                val statusBarInsets = insets.getInsets(WindowInsetsCompat.Type.statusBars())
                val navigationBarInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars())
                window.decorView.setPadding(
                    0,
                    statusBarInsets.top,
                    0,
                    navigationBarInsets.bottom
                )
                insets
            }

            observeNetworkState(this, this)
        }
    }
}