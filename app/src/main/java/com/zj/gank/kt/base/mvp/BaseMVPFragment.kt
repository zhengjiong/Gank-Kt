package com.zj.gank.kt.base.mvp

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.view.View

/**
 *
 * CreateTime: 17/10/27 09:57
 * @author zhengjiong
 */

abstract class BaseMVPFragment<V : BaseMVPContract.View, P : BaseMVPContract.Presenter<V>> : Fragment(), BaseMVPContract.View {

    protected var presenter: P? = null

    @CallSuper
    @SuppressWarnings
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(BaseViewModel::class.java) as BaseViewModel<V, P>

        var isPresenterCreated = false
        if (viewModel.getPresenter() == null) {
            viewModel.setPresenter(initPresenter())
            isPresenterCreated = true
        }

        presenter = viewModel.getPresenter()
        presenter!!.attachLifecycle(lifecycle)
        presenter!!.attachView(this as V)
        if (isPresenterCreated) {
            presenter!!.onPresenterCreate()
        }
    }

    override fun onDestroy() {
        presenter!!.detachLifecycle(lifecycle)
        presenter!!.detachView()
        super.onDestroy()
    }

    protected abstract fun initPresenter(): P
}