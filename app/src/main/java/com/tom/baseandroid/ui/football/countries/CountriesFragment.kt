package com.tom.baseandroid.ui.football.countries

import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseFragment
import com.tom.baseandroid.databinding.FragmentCoutriesBinding
import com.tom.baseandroid.di.injectViewModel

/**
 * Created by vantrang on 8/16/20.
 */
class CountriesFragment : BaseFragment<FragmentCoutriesBinding, CountriesViewModel>() {
    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<CountriesViewModel> = CountriesViewModel::class.java

    override fun initView() {
    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_coutries
}