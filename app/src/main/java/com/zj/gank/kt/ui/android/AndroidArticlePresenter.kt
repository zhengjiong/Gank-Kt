package com.zj.gank.kt.ui.android

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import com.zj.gank.kt.data.bean.Article
import com.zj.gank.kt.data.bean.JsonResult
import com.zj.gank.kt.data.model.ArticleModle
import com.zj.gank.kt.ui.api.ApiPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 *
 * CreateTime: 17/10/25 15:55
 * @author zhengjiong
 */


class AndroidArticlePresenter @Inject constructor(val model: ArticleModle) : ApiPresenter<AndroidArticleContract.View>(), AndroidArticleContract.Presenter {

    @OnLifecycleEvent(value = Lifecycle.Event.ON_START)
    fun refresh() {
        disposable.add(model.getAndroidArticle(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Consumer<JsonResult<List<Article>>> {
                    override fun accept(it: JsonResult<List<Article>>?) {
                        if (!it!!.error) {
                            getView()?.onDataReceive(it.results)
                        } else {
                            getView()?.showError("加载失败")
                        }
                    }

                }, object : Consumer<Throwable> {
                    override fun accept(t: Throwable?) {
                        getView()?.showError(t?.message)
                    }
                }))
    }
}