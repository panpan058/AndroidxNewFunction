package com.huayu.androidxnewfunction.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.huayu.androidxnewfunction.R
import com.huayu.androidxnewfunction.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_index.*

/**
 *  <pre>
 *     Created by ppW
 *     e-mail : wangpanpan05@163.com
 *     time   : 2019/12/02
 *     desc   : 要修改成的Fragment
 *     version: 1.0   初始化
 *     params:
 *  <pre>
 */
class ChangedFragment : Fragment() {
    companion object {
        fun getInstance(index: Int): ChangedFragment = ChangedFragment().apply {
            arguments = bundleOf("index" to index)
        }
    }

    var index: Int? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_index, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            index = it.getInt("index")
            tv_frgIndex.text = "修改的Fragment$index"
        }
        context?.let {
            tv_frgIndex.setBackgroundColor(it.resources.getColor(R.color.colorAccent))
        }
    }

    override fun onResume() {
        super.onResume()
        Log.e("indexFragment", "目前显示第${index}个fragment")
        val str = "目前显示第${index}个fragment"
        Log.e("indexFragment", str)
        val mainActivity = activity as MainActivity
        mainActivity.logFragment(str)
    }
}