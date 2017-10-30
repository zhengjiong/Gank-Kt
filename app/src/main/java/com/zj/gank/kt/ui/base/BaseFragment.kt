package com.zj.gank.kt.ui.base

import android.content.Context
import com.zj.gank.kt.base.mvp.BaseMVPFragment
import com.zj.gank.kt.base.mvp.BaseMVPPresenter
import com.zj.gank.kt.di.component.ActivityComponent

/**
 * Created by zhengjiong
 * date: 2017/10/25 21:45
 */
abstract class BaseFragment<V : BaseContract.View, P : BaseContract.Presenter<V>> : BaseMVPFragment<V, P>() {

    lateinit var activityComponent: ActivityComponent
    lateinit var activity: BaseActivity<*, *>

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            this.activity = context
            activityComponent = activity.activityComponent
            injectDependencies()
        }

    }

    abstract fun injectDependencies()
}