package com.openld.keeplivesample.keeplive

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * author: lllddd
 * created on: 2022/12/23 16:29
 * description:保持存活的Service
 */
class KeepLiveService : Service() {
    private lateinit var mHelper: ScreenStatusHelper

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

        mHelper = ScreenStatusHelper(this@KeepLiveService, ScreenBroadcastReceiver())

        mHelper.begin(object : ScreenStatusHelper.ScreenStatusListener {
            override fun onScreenOff() {
                KeepLiveManager.getInstance(this@KeepLiveService).createKeepLiveActivity()
            }

            override fun onScreenOn() {
                KeepLiveManager.getInstance(this@KeepLiveService).finishKeepLiveActivity()
            }

            override fun onUserPresent() {

            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        mHelper.unregister()
    }
}