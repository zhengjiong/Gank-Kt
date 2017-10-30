package com.zj.gank.kt.ui.base

import com.zj.gank.kt.base.mvp.BaseMVPPresenter

/**
 *
 * CreateTime: 17/10/31 02:35
 * @author zhengjiong
 */

abstract class BasePresenter<V : BaseContract.View> : BaseMVPPresenter<V>(), BaseContract.Presenter<V>