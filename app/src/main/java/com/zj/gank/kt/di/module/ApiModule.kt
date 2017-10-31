package com.zj.gank.kt.di.module

import android.util.Log
import com.zj.gank.kt.BuildConfig
import com.zj.gank.kt.data.network.ApiConstants
import com.zj.gank.kt.data.network.GankApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String?) {
                Log.e("RetrofitLog", "retrofitBack ======================= " + message);
            }

        })
    }

    @Singleton
    @Provides
    fun provideOkHttpBuilder(logging: HttpLoggingInterceptor): OkHttpClient.Builder {
        val okhttpBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
            okhttpBuilder.addInterceptor(logging)
        }

        okhttpBuilder.readTimeout(15L, TimeUnit.SECONDS)
        okhttpBuilder.connectTimeout(15L, TimeUnit.SECONDS)
        return okhttpBuilder
    }

    @Named("gankRetrofit")
    @Singleton
    @Provides
    fun provideGankRetrofit(okHttpClientBuilder: OkHttpClient.Builder,
                            @Named("gank") baseUrl: String): Retrofit {
        //val client = okHttpClientBuilder.addInterceptor().build()
        return Retrofit.Builder()
                .client(okHttpClientBuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
    }

    @Singleton
    @Provides
    fun provideGankApiService(@Named("gankRetrofit") retrofit: Retrofit): GankApiService {
        return retrofit.create(GankApiService::class.java)
    }
}