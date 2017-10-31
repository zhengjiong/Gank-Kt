package com.zj.gank.kt.di.component

import com.zj.gank.kt.di.scope.PerActivity
import com.zj.gank.kt.ui.android.AndroidArticleFragment
import dagger.Module
import dagger.Subcomponent
import javax.inject.Singleton

/**
 *
 * CreateTime: 17/10/25 15:48
 * @author zhengjiong
 */

@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(fragment: AndroidArticleFragment)
}


@Module
class ActivityModule{

}