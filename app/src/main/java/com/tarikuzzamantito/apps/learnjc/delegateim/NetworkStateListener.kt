package com.tarikuzzamantito.apps.learnjc.delegateim

import android.content.Context
import androidx.lifecycle.LifecycleOwner

/**
 * Created by Tarikuzzaman on 3/8/2025 12:44 PM
 */
interface NetworkStateListener {

    fun observeNetworkState(context: Context, lifecycleOwner: LifecycleOwner)

    //fun onNetworkStateChanged(isConnected: Boolean)
}