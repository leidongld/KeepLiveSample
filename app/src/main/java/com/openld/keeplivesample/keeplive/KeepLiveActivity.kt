package com.openld.keeplivesample.keeplive

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * author: lllddd
 * created on: 2022/12/23 16:22
 * description:锁屏时保持存活的Activity
 */
class KeepLiveActivity : AppCompatActivity() {
    private val TAG = "KeepLiveActivity"

    @SuppressLint("RtlHardcoded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 这边把页面传给管理器，因为那边要控制finish()掉该对象
        KeepLiveManager.getInstance(this).setKeepLiveActivity(this)

        val window = window
        val windowAttrs = window.attributes
        windowAttrs.gravity = Gravity.LEFT and Gravity.TOP

        windowAttrs.width = 1
        windowAttrs.height = 1
        windowAttrs.x = 0
        windowAttrs.y = 0

        window.attributes = windowAttrs

        Toast.makeText(this, "KeepAliveActivity onCreate", Toast.LENGTH_LONG).show()
        Log.d(TAG, ">>> onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "KeepAliveActivity onDestroy", Toast.LENGTH_LONG).show()
        Log.d(TAG, ">>> onDestroy")
    }
}