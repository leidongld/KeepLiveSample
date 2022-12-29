package com.openld.keeplivesample.keeplive

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * author: lllddd
 * created on: 2022/12/23 16:33
 * description:屏幕状态变化时候的广播接收者
 */
class ScreenBroadcastReceiver : BroadcastReceiver() {

    private lateinit var mListener: ScreenStatusHelper.ScreenStatusListener

    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action

        if (Intent.ACTION_SCREEN_ON == action) {
            mListener.onScreenOn()
        } else if (Intent.ACTION_SCREEN_OFF == action) {
            mListener.onScreenOff()
        } else if (Intent.ACTION_USER_PRESENT == action) {
            mListener.onUserPresent()
        }
    }

    fun bindListener(listener: ScreenStatusHelper.ScreenStatusListener) {
        mListener = listener
    }
}
