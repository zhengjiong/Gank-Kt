package com.zj.gank.kt.di.module

import com.zj.gank.kt.BuildConfig
import com.zj.gank.kt.data.network.ApiConstants
import com.zj.gank.kt.data.network.GankApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 *
 * CreateTime: 17/10/25 10:23
 * @author zhengjiong
 */

@Module
class ApiModule {

    @Named("gank")
    @Provides
    fun provideGankApiUri() = ApiConstants.GANK_URI

    @Singleton
    @Provides
    fun provideOkHttpBuilder(): OkHttpClient.Builder {
        val okhttpBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BASIC
            okhttpBuilder.addInterceptor(logging)
        }

        okhttpBuilder.readTimeout(15L, TimeUnit.SECONDS)
        okhttpBuilder.connectTimeout(15L, TimeUnit.SECONDS)
        return okhttpBuilder
    }

    @Named("gankRetrofit")
    @Singleton
    @Provides
    fun provideGankRetrofit(retrofitBuilder: Retrofit.Builder,
                            okHttpClientBuilder: OkHttpClient.Builder,
                            @Named("gank") baseUrl: String): Retrofit {
        //val client = okHttpClientBuilder.addInterceptor().build()
        return retrofitBuilder
                .client(okHttpClientBuilder.build())
                .baseUrl(baseUrl)
                .build()
    }

    @Singleton
    @Provides
    fun provideGankApiService(@Named("gankRetrofit") retrofit: Retrofit): GankApiService {
        return retrofit.create(GankApiService::class.java)
    }
}