package com.zj.gank.kt.di.component

import com.zj.gank.kt.di.module.ApiModule
import com.zj.gank.kt.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 *
 * CreateTime: 17/10/25 13:31
 * @author zhengjiong
 */

@Singleton
@Component(modules = arrayOf(ApiModule::class, ApplicationModule::class))
interface ApplicationComponent {
    //fun inject(fragment)

    fun plus(): ArticleComponent
}