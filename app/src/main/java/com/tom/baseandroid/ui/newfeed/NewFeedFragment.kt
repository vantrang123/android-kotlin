package com.tom.baseandroid.ui.newfeed

import android.util.Log
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseFragment
import com.tom.baseandroid.base.EmptyViewModel
import com.tom.baseandroid.databinding.FragmentHomeBinding
import com.tom.baseandroid.di.injectViewModel
import timber.log.Timber

/**
 *Created by VanTrang.
 */
class NewFeedFragment : BaseFragment<FragmentHomeBinding , EmptyViewModel>() {
    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<EmptyViewModel> = EmptyViewModel::class.java

    override fun initView() {}

    override fun getLayoutResourceId(): Int = R.layout.fragment_new_feed

    override fun setMenuVisibility(menuVisible: Boolean) {
        super.setMenuVisibility(menuVisible)
        if (menuVisible) {
            Timber.d("NewFeedFragment is visible ");
        }else {
            Timber.d("NewFeedFragment is not visible ");
        }
    }
}