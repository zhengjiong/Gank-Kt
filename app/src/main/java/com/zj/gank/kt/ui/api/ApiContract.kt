package com.zj.gank.kt.ui.api

import com.zj.gank.kt.ui.base.BaseContract

/**
 *
 * CreateTime: 17/10/31 04:47
 * @author zhengjiong
 */

interface ApiContract {

    interface View : BaseContract.View {
        fun showLoading()
        fun hideLoading()
        fun showError(message: String?)
    }

    interface Presenter<V : BaseContract.View> : BaseContract.Presenter<V>
}