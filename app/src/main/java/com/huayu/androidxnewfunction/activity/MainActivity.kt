package com.huayu.androidxnewfunction.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.huayu.androidxnewfunction.R
import com.huayu.androidxnewfunction.adapter.IndexPagerAdapter
import com.huayu.androidxnewfunction.fragment.ChangedFragment
import com.huayu.androidxnewfunction.fragment.IndexFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragments()
    }

    private val titles = mutableListOf<CharSequence>()
    private val fragments = mutableListOf<Fragment>()
    private lateinit var adapter: IndexPagerAdapter
    private fun initFragments() {
        for (i in 0..10) {
            titles.add("标题$i")
            fragments.add(IndexFragment.getInstance(i))
        }
        adapter = IndexPagerAdapter(supportFragmentManager, fragments, titles)
        vp_main.adapter = adapter
        tab_main.setupWithViewPager(vp_main)
    }

    fun changeFragment() {
        val currentItem = vp_main.currentItem
        fragments[currentItem] = ChangedFragment.getInstance(currentItem)
        adapter.notifyDataSetChanged()
    }

    fun logFragment(details: String) {
        tv_main.text = details
    }
}
