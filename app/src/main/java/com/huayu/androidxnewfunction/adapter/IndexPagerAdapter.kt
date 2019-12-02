package com.huayu.androidxnewfunction.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter

/**
 *  <pre>
 *     Created by ppW
 *     e-mail : wangpanpan05@163.com
 *     time   : 2019/12/02
 *     desc   :
 *     version: 1.0   初始化
 *     params:
 *  <pre>
 */
class IndexPagerAdapter(
    fm: FragmentManager,
    private val mFragments: List<Fragment>,
    private val mTitls: List<CharSequence>
) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getItemId(position: Int): Long {
        return mFragments[position].hashCode().toLong()
    }

    override fun getItemPosition(`object`: Any): Int {
        val index = mFragments.indexOf(`object`)
        if (index == -1) {
            return PagerAdapter.POSITION_NONE
        }
        return PagerAdapter.POSITION_UNCHANGED
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitls[position]
    }
}