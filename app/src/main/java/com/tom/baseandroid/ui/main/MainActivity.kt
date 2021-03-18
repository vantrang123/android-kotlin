package com.tom.baseandroid.ui.main

import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
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
        changeStatusBarColor(R.color.transparent)
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
            addOnPageChangeListener(
                object : ViewPager.OnPageChangeListener {
                    override fun onPageScrolled(
                        position: Int,
                        positionOffset: Float,
                        positionOffsetPixels: Int
                    ) {}

                    override fun onPageSelected(position: Int) {
                        changeStatusBarColor(if (position == 0) R.color.transparent else R.color.blue_light)
                    }

                    override fun onPageScrollStateChanged(state: Int) {}

                }
            )
        }
    }

    private fun changeStatusBarColor(color: Int) {
        window?.apply {
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            statusBarColor =
                ContextCompat.getColor(this@MainActivity, color)
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