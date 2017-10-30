package com.zj.gank.kt.ui.android

import com.zj.gank.kt.data.bean.Article
import com.zj.gank.kt.ui.base.BaseFragment

/**
 *
 * CreateTime: 17/10/25 15:54
 * @author zhengjiong
 */


class AndroidArticleFragment : BaseFragment<AndroidArticleContract.View, AndroidArticleContract.Presenter>(), AndroidArticleContract.View {
    override fun injectDependencies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initPresenter(): AndroidArticleContract.Presenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDataReceive(list: List<Article>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}