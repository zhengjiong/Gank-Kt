package com.zj.gank.kt.data.network

import com.zj.gank.kt.data.bean.Article
import com.zj.gank.kt.data.bean.JsonResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * CreateTime: 17/10/25 10:52
 * @author zhengjiong
 */
interface GankApiService {

    @GET("data/Android/10/{page}")
    fun getAndroidData(@Path("page") page: Int): Observable<JsonResult<List<Article>>>

    @GET("data/福利/10/{page}")
    fun getGirlData(@Path("page") page:Int):Observable<JsonResult<List<Article>>>
}