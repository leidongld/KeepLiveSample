package com.openld.keeplivesample.keeplive

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.PowerManager

/**
 * author: lllddd
 * created on: 2022/12/23 17:01
 * description:手机屏幕状态监听器
 */
class ScreenStatusHelper(context: Context, receiver: ScreenBroadcastReceiver) {
    private val mContext: Context = context
    private val mScreenReceiver: ScreenBroadcastReceiver = receiver

    private lateinit var mScreenStatusListener: ScreenStatusListener

    fun begin(listenr: ScreenStatusListener) {
        mScreenStatusListener = listenr
        mScreenReceiver.bindListener(mScreenStatusListener)
        register()
        getScreenStatus()
    }

    private fun getScreenStatus() {
        val manager: PowerManager =
            mContext.getSystemService(Context.POWER_SERVICE) as PowerManager

        if (manager.isScreenOn) {
            mScreenStatusListener.onScreenOn()
        } else {
            mScreenStatusListener.onScreenOff()
        }
    }

    private fun register() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_SCREEN_ON)
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF)
        intentFilter.addAction(Intent.ACTION_USER_PRESENT)
        mContext.registerReceiver(mScreenReceiver, intentFilter)
    }

    fun unregister() {
        mContext.unregisterReceiver(mScreenReceiver)
    }

    /**
     * 屏幕状态监听器
     */
    interface ScreenStatusListener {
        /**
         * 锁屏回调
         */
        fun onScreenOff()

        /**
         * 开屏回调
         */
        fun onScreenOn()

        /**
         * 当前用户可见
         */
        fun onUserPresent()
    }
}