package com.zj.gank.kt.base.mvp

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.os.Bundle

/**
 * Created by zhengjiong
 * date: 2017/10/26 22:03
 */
abstract class BaseMVPPresenter<V : BaseMVPContract.View> : LifecycleObserver, BaseMVPContract.Presenter<V> {
    private var stateBundle: Bundle? = null
    private var view: V? = null
    /*override fun getView(): V {
        return view
    }*/

    override fun getView(): V? = view

    override fun attachLifecycle(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }

    override fun detachLifecycle(lifecycle: Lifecycle) {
        lifecycle.removeObserver(this)
    }

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun isViewAttached(): Boolean = view != null

    override fun getStateBundle(): Bundle = if (stateBundle == null) {
        Bundle()
    } else {
        stateBundle!!
    }

    override fun onPresenterCreate() {

    }

    override fun onPresenterDestroy() {
        if (stateBundle != null && !stateBundle!!.isEmpty) {
            stateBundle!!.clear()
        }
    }
}