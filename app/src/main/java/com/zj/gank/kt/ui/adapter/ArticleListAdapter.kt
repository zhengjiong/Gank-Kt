package com.zj.gank.kt.ui.adapter

import android.support.constraint.ConstraintLayout
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.zj.gank.kt.R
import com.zj.gank.kt.data.bean.Article
import com.zj.gank.kt.ui.viewholder.ArticleViewHolder

/**
 *
 * CreateTime: 17/11/1 14:44
 * @author zhengjiong
 */

class ArticleListAdapter(layoutResId: Int = R.layout.item_article_layout) : BaseQuickAdapter<Article, ArticleViewHolder>(layoutResId) {

    override fun convert(helper: ArticleViewHolder, item: Article) {
        helper.getView<TextView>(R.id.title).text = item.desc
        helper.getView<TextView>(R.id.who).text = item.who
        helper.getView<TextView>(R.id.date).text = item.publishedAt.substring(0..9)

        val imageView = helper.getView<ImageView>(R.id.icon)
        if (item.images != null && item.images.isNotEmpty()) {
            imageView.layoutParams.height = ConvertUtils.dp2px(120F)
            Glide.with(mContext)
                    .load(item.images[0])
                    //.apply(RequestOptions().dontAnimate())
                    //.placeholder(R.drawable.loading_spinner)
                    .into(imageView);
        } else {
            imageView.layoutParams.height = ConvertUtils.dp2px(0F)
        }

    }

}