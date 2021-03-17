package com.tom.baseandroid.ui.main

import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseActivity
import com.tom.baseandroid.base.EmptyViewModel
import com.tom.baseandroid.databinding.ActivityMainBinding
import com.tom.baseandroid.di.injectViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 *Created by VanTrang on 8/22/2019.
 */
class MainActivity : BaseActivity<ActivityMainBinding, EmptyViewModel>() {
    private var mAdapter: MainViewpagerAdapter? = null

    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<EmptyViewModel> = EmptyViewModel::class.java

    override fun initView() {
        setupViewPager()
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_main

    private fun setupViewPager() {
        viewPager.apply viewPager@{
            setPagingEnable(true)
            mAdapter = MainViewpagerAdapter(this@MainActivity, supportFragmentManager)
            adapter = mAdapter
            offscreenPageLimit = 5
            tabLayout.apply tabLayout@{
                setupWithViewPager(this@viewPager)
                for (i in 0..tabCount) {
                    getTabAt(i)?.customView = mAdapter?.getTabView(i)
                }
            }
        }
    }

    override fun onBackPressed() {
        if (viewPager?.currentItem != 0) {
            viewPager?.currentItem = 0
            return
        }
        moveTaskToBack(false)
    }
}