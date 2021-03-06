package com.zj.gank.kt.ui.android

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.chad.library.adapter.base.BaseQuickAdapter
import com.zj.gank.kt.App
import com.zj.gank.kt.R
import com.zj.gank.kt.data.bean.Article
import com.zj.gank.kt.ui.adapter.ArticleListAdapter
import com.zj.gank.kt.ui.base.BaseFragment
import com.zj.gank.kt.ui.viewholder.ArticleViewHolder
import kotlinx.android.synthetic.main.fragment_android_article_layout.*
import javax.inject.Inject

/**
 *
 * CreateTime: 17/10/25 15:54
 * @author zhengjiong
 */


class AndroidArticleFragment : BaseFragment<AndroidArticleContract.View, AndroidArticleContract.Presenter>(), AndroidArticleContract.View {

    @Inject
    protected lateinit var articlePresenter: AndroidArticlePresenter

    //private var recyclerView: RecyclerView? = null

    companion object {
        fun newInstance(): AndroidArticleFragment {
            return AndroidArticleFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_android_article_layout, container, false)
        //recyclerView = view.findViewById(R.id.recyclerview)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerview.adapter = ArticleListAdapter()
        articlePresenter.refresh()
    }

    override fun injectDependencies() {
        App.instance.appComponent.plus().inject(this)
    }

    override fun initPresenter(): AndroidArticleContract.Presenter {
        return articlePresenter
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onRefreshReceive(list: List<Article>) {
        (recyclerview.adapter as BaseQuickAdapter<Article, ArticleViewHolder>).setNewData(list)
    }

    override fun onLoadMoreReceive(list: List<Article>) {

    }

    override fun showError(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showNoData() {

    }

}