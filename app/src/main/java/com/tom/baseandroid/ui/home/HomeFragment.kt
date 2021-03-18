package com.tom.baseandroid.ui.home

import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseFragment
import com.tom.baseandroid.base.EmptyViewModel
import com.tom.baseandroid.data.model.Banner
import com.tom.baseandroid.databinding.FragmentHomeBinding
import com.tom.baseandroid.di.injectViewModel
import com.tom.baseandroid.extensions.dp
import com.zhpan.bannerview.BannerViewPager
import com.zhpan.bannerview.constants.IndicatorGravity
import com.zhpan.bannerview.constants.PageStyle
import com.zhpan.indicator.DrawableIndicator
import com.zhpan.indicator.base.IIndicator
import com.zhpan.indicator.enums.IndicatorSlideMode
import java.util.ArrayList

/**
 *Created by VanTrang.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding, EmptyViewModel>() {
    private lateinit var mViewPager: BannerViewPager<Banner, BannerViewHolder>
    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<EmptyViewModel> = EmptyViewModel::class.java

    override fun initView() {
        initBanner()
    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_home

    private fun initBanner() {
        mViewPager = requireActivity().findViewById(R.id.banner_view)
        mViewPager.apply {
            setAutoPlay(true)
            setCanLoop(true)
            setAdapter(BannerAdapter())
            setIndicatorView(getVectorDrawableIndicator())
            setIndicatorSlideMode(IndicatorSlideMode.SMOOTH)
            setIndicatorGravity(IndicatorGravity.START)
            setInterval(2000)
            setPageStyle(PageStyle.MULTI_PAGE)
            create(getPicList())
        }
    }

    private fun getPicList(): MutableList<Banner> {
        val mPictureList: MutableList<Banner> = ArrayList()
        mPictureList.clear()
        for (i in 0..4) {
            val drawable = resources.getIdentifier("advertise$i", "drawable", requireContext().packageName)
            mPictureList.add(Banner().apply {
                imageRes = drawable
            })
        }
        return mPictureList
    }

    private fun getVectorDrawableIndicator(): IIndicator {
        return DrawableIndicator(context)
                .setIndicatorGap(2.dp)
                .setIndicatorDrawable(
                        R.drawable.banner_indicator_nornal,
                        R.drawable.banner_indicator_focus
                )
                .setIndicatorSize(7.dp, 2.dp, 7.dp, 7.dp)
    }
}