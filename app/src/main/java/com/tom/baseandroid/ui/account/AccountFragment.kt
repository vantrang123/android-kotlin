package com.tom.baseandroid.ui.account

import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseFragment
import com.tom.baseandroid.base.EmptyViewModel
import com.tom.baseandroid.databinding.FragmentHomeBinding
import com.tom.baseandroid.di.injectViewModel
import timber.log.Timber

/**
 *Created by VanTrang.
 */
class AccountFragment : BaseFragment<FragmentHomeBinding , EmptyViewModel>() {
    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<EmptyViewModel> = EmptyViewModel::class.java

    override fun initView() {
    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_account

    override fun setMenuVisibility(menuVisible: Boolean) {
        super.setMenuVisibility(menuVisible)
        if (menuVisible) {
            Timber.d("AccountFragment is visible ");
        }else {
            Timber.d("AccountFragment is not visible ");
        }
    }
}