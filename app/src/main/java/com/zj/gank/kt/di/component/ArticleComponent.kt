package com.zj.gank.kt.di.component

import com.zj.gank.kt.di.scope.PerActivity
import com.zj.gank.kt.ui.android.AndroidArticleFragment
import dagger.Subcomponent

/**
 *
 * CreateTime: 17/10/25 15:48
 * @author zhengjiong
 */

@Subcomponent
interface ArticleComponent {
    fun inject(fragment: AndroidArticleFragment)
}