package com.zj.gank.kt.data.model

import com.zj.gank.kt.data.bean.Article
import com.zj.gank.kt.data.bean.JsonResult
import com.zj.gank.kt.data.network.GankApiService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by zhengjiong
 * date: 2017/10/31 15:22
 */

class ArticleModle @Inject constructor(val api: GankApiService) {

    fun getAndroidArticle(page: Int): Observable<JsonResult<List<Article>>> {
        return api.getAndroidData(page)
    }
}