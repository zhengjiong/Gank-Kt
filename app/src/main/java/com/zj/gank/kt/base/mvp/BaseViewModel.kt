package com.zj.gank.kt.base.mvp

import android.arch.lifecycle.ViewModel

/**
 * Created by zhengjiong
 * date: 2017/10/25 22:05
 */

class BaseViewModel<V : BaseMVPContract.View, P : BaseMVPContract.Presenter<V>> : ViewModel() {

    private var presenter: P? = null

    internal fun setPresenter(presenter: P) {
        this.presenter = this.presenter ?: presenter
    }

    fun getPresenter() = presenter

    override fun onCleared() {
        super.onCleared()
        presenter?.onPresenterDestroy()
        presenter = null
    }
}