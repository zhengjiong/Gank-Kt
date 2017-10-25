package com.zj.gank.kt.data.bean

/**
 *
 * CreateTime: 17/10/25 10:55
 * @author zhengjiong
 */

data class Article(
        val _id: String,
        val createdAt: String,
        val desc: String,
        val images: Array<String>,
        val publishedAt: String,
        val source: String,
        val type: String,
        val url: String,
        val used: Boolean,
        val who: String
)