package com.zj.gank.kt

import android.app.Application
import com.zj.gank.kt.di.component.ApplicationComponent
import com.zj.gank.kt.di.component.DaggerApplicationComponent

/**
 * Created by zhengjiong
 * date: 2017/10/23 22:00
 */
class App : Application() {

    companion object {
        lateinit var instance: App
    }


    /**
     * 延迟初始化, 避免程序启动卡顿
     */
    val appComponent: ApplicationComponent by lazy(LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent.builder().build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}