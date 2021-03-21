package com.tom.baseandroid.ui.tutorial

import android.animation.ObjectAnimator
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseActivity
import com.tom.baseandroid.base.IActivity
import com.tom.baseandroid.data.model.Tutorial
import com.tom.baseandroid.databinding.ActivityTutorialBinding
import com.tom.baseandroid.di.injectViewModel
import com.tom.baseandroid.extensions.dp
import com.tom.baseandroid.extensions.lauchActivity
import com.tom.baseandroid.extensions.visible
import com.tom.baseandroid.preference.IConfigurationPrefs
import com.tom.baseandroid.ui.login.LoginActivity
import com.tom.baseandroid.ui.main.MainActivity
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.adapter.OnPageChangeListenerAdapter
import com.zhpan.bannerview.holder.HolderCreator
import com.zhpan.indicator.enums.IndicatorSlideMode
import kotlinx.android.synthetic.main.activity_tutorial.*
import java.util.ArrayList
import javax.inject.Inject

/**
 *Created by VanTrang on 8/22/2019.
 */
class TutorialActivity : BaseActivity<ActivityTutorialBinding, TutorialViewModel>(), IActivity {
    @Inject
    lateinit var prefs: IConfigurationPrefs

    private lateinit var mViewPager: BannerViewPager<Tutorial, TutorialViewHolder>
    private var mDrawableList: MutableList<Int> = ArrayList()
    private val data: List<Tutorial>
        get() {
            val list = ArrayList<Tutorial>()
            for (i in mDrawableList.indices) {
                val customBean = Tutorial()
                customBean.imageRes = mDrawableList[i]
                list.add(customBean)
            }
            return list
        }

    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<TutorialViewModel> = TutorialViewModel::class.java

    override fun initView() {
        window?.apply {
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            statusBarColor =
                ContextCompat.getColor(this@TutorialActivity, R.color.transparent)
        }
        getDrawables()
        setUpViewPager()
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_tutorial

    override fun navigation() {
        prefs.isFirstUseApp = false
        if (prefs.user != null) {
            lauchActivity<MainActivity> { }
        } else {
            lauchActivity<LoginActivity> { }
        }
    }

    private fun getDrawables() {
        for (i in 0..2) {
            val drawable = resources.getIdentifier("guide$i", "drawable", packageName)
            mDrawableList.add(drawable)
        }
    }

    private fun setUpViewPager() {
        mViewPager = findViewById(R.id.viewPager)
        mViewPager.apply {
            setAutoPlay(false)
            setCanLoop(false)
            setIndicatorSlideMode(IndicatorSlideMode.SMOOTH)
            setIndicatorSliderRadius(3.dp, 4.dp)
            setIndicatorMargin(0, 0, 0, 15.dp) // can setMargin here
//            setAdapter(TutorialAdapter())
            setHolderCreator(HolderCreator { TutorialViewHolder() })
            setIndicatorSliderColor(ContextCompat.getColor(this@TutorialActivity, R.color.gray_chalice), ContextCompat.getColor(this@TutorialActivity, R.color.blue_light))
            setOnPageChangeListener(object : OnPageChangeListenerAdapter() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    btnStart.apply {
                        visible(position == 2)
                        ObjectAnimator
                                .ofFloat(this, "alpha", 0f, 1f)
                                .setDuration(ANIMATION_DURATION.toLong()).start()
                    }
                }
            })
            create(this@TutorialActivity.data)
        }

        btnStart.setOnClickListener { navigation() }
    }

    companion object {
        private const val ANIMATION_DURATION = 1300
    }
}