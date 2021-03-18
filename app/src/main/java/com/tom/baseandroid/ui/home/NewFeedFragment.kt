package com.tom.baseandroid.ui.home

import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseFragment
import com.tom.baseandroid.base.EmptyViewModel
import com.tom.baseandroid.databinding.FragmentHomeBinding
import com.tom.baseandroid.di.injectViewModel

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
}