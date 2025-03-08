package com.tarikuzzamantito.apps.learnjc.delegateim

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner

/**
 * Created by Tarikuzzaman on 3/8/2025 12:47 PM
 */
class NetworkStateHandler: NetworkStateListener {
    override fun observeNetworkState(
        context: Context,
        lifecycleOwner: LifecycleOwner
    ) {
        Log.v("TAGY", "Observe the Network State")
    }

}