package com.zj.gank.kt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.zj.gank.kt.ui.android.AndroidArticleFragment
import com.zj.gank.kt.ui.base.BaseActivity
import com.zj.gank.kt.ui.base.BaseContract
import com.zj.gank.kt.ui.ios.IOSArticleFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<BaseContract.View, BaseContract.Presenter<BaseContract.View>>() {
    override fun injectDependencies() {

    }

    override fun initPresenter(): BaseContract.Presenter<BaseContract.View>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragments = listOf(
                AndroidArticleFragment.newInstance(),
                IOSArticleFragment.newInstance(),
                IOSArticleFragment.newInstance(),
                IOSArticleFragment.newInstance()
        )
        viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return fragments.get(position)
            }

            override fun getCount() = fragments.size
        }
    }
}
