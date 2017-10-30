package com.zj.gank.kt.ui.android

import com.zj.gank.kt.data.bean.Article
import com.zj.gank.kt.ui.api.ApiContract

/**
 *
 * CreateTime: 17/10/25 15:56
 * @author zhengjiong
 */

interface AndroidArticleContract {

    interface View : ApiContract.View {
        fun onDataReceive(list: List<Article>)
        fun showNoData()
    }

    interface Presenter : ApiContract.Presenter<View>
}
