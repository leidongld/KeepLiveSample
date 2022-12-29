package com.openld.keeplivesample.keeplive

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import java.lang.ref.WeakReference

/**
 * author: lllddd
 * created on: 2022/12/23 16:33
 * description:存活管理器
 */
class KeepLiveManager private constructor(context: Context) {
    companion object {
        @SuppressLint("StaticFieldLeak")
        private var sInstance: KeepLiveManager? = null

        fun getInstance(context: Context): KeepLiveManager {
            if (sInstance == null) {
                sInstance = KeepLiveManager(context.applicationContext)
            }
            return sInstance as KeepLiveManager
        }
    }

    private var mContext: Context = context

    private var mWeakReference: WeakReference<AppCompatActivity>? = null

    /**
     * 设置保活的页面
     */
    fun setKeepLiveActivity(activity: KeepLiveActivity) {
        mWeakReference = WeakReference(activity)
    }

    /**
     * 启动保活页面
     */
    fun createKeepLiveActivity() {
        if (mContext is KeepLiveActivity) {
            return
        }

        mContext.startActivity(Intent(mContext, KeepLiveActivity::class.java))
    }

    /**
     * 关闭保活页面
     */
    fun finishKeepLiveActivity() {
        if (mWeakReference?.get() == null) {
            return
        }

        mWeakReference!!.get()!!.finish()
    }
}