package com.zj.gank.kt.base.mvp

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by zhengjiong
 * date: 2017/10/25 21:47
 */
abstract class BaseMVPActivity<V : BaseMVPContract.View, P : BaseMVPContract.Presenter<V>> : AppCompatActivity(), BaseMVPContract.View {
    var presenter: P? = null

    abstract fun initPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(BaseViewModel::class.java) as BaseViewModel<V, P>//todo

        var isPresenterCreated = false
        if (viewModel.getPresenter() == null) {
            viewModel.setPresenter(initPresenter())
            isPresenterCreated = true
        }

        presenter = viewModel.getPresenter()
        presenter!!.attachLifecycle(lifecycle)
        presenter!!.attachView(this as V)
        if (isPresenterCreated) {
            presenter?.onPresenterCreate()
        }
    }

    override fun onDestroy() {
        presenter!!.detachLifecycle(lifecycle)
        presenter!!.detachView()
        super.onDestroy()
    }
}