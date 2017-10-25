package com.zj.gank.kt.ui.base

import com.zj.gank.kt.base.mvp.BaseMVPContract

/**
 *
 * CreateTime: 17/10/25 15:57
 * @author zhengjiong
 */

interface BaseContract {
    interface View : BaseMVPContract.View

    interface Presenter:BaseMVPContract.Presenter<BaseMVPContract.View>
}

