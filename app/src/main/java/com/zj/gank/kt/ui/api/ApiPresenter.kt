package com.zj.gank.kt.ui.api

import com.zj.gank.kt.ui.base.BaseContract
import com.zj.gank.kt.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by zhengjiong
 * date: 2017/10/31 15:56
 */
abstract class ApiPresenter<V : BaseContract.View> : BasePresenter<V>() {
    val disposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun onPresenterDestroy() {
        super.onPresenterDestroy()
        disposable.clear()
    }
}