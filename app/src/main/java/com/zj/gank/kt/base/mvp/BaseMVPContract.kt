package com.zj.gank.kt.base.mvp

import android.arch.lifecycle.Lifecycle
import android.os.Bundle

/**
 * Created by zhengjiong
 * date: 2017/10/23 22:35
 */
interface BaseMVPContract {

    interface View {

    }

    interface Presenter<V : BaseMVPContract.View> {

        val stateBundle: Bundle

        val view: V

        val isViewAttached: Boolean

        fun attachLifecycle(lifecycle: Lifecycle)

        fun detachLifecycle(lifecycle: Lifecycle)

        fun attachView(view: V)

        fun detachView()

        fun onPresenterCreate()

        fun onPresenterDestroy()
    }
}