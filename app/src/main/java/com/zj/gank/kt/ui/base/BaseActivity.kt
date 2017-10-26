package com.zj.gank.kt.ui.base

import android.content.DialogInterface
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AlertDialog
import com.zj.gank.kt.App
import com.zj.gank.kt.base.mvp.BaseMVPActivity

/**
 *
 * CreateTime: 17/10/26 08:53
 * @author zhengjiong
 */


abstract class BaseActivity<V : BaseContract.View, P : BaseContract.Presenter<V>> : BaseMVPActivity<V, P>() {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
    }

    @CallSuper
    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun getAppComponent() = App.instance.appComponent

    fun showDialog(title: String, message: String, buttonText: String) {
        AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(buttonText) { dialogInterface, i ->
                    dialogInterface.dismiss()
                }
                .show()
    }



    protected abstract fun injectDependencies()
}