package com.zj.gank.kt.base.mvp

/**
 *
 * CreateTime: 17/10/31 02:25
 * @author zhengjiong
 */


interface BaseLoadingContract {
    interface View : BaseMVPContract.View {
        fun showLoading()
        fun hideLoading()
        fun showError(errorMessage: String)
    }

    interface Presenter : BaseMVPContract.Presenter<View> {

    }
}