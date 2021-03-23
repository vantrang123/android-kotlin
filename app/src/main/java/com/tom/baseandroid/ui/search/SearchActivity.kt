package com.tom.baseandroid.ui.search

import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseActivity
import com.tom.baseandroid.databinding.ActivitySearchBinding
import com.tom.baseandroid.di.injectViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity<ActivitySearchBinding, SearchViewModel>() {
    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<SearchViewModel> = SearchViewModel::class.java

    override fun initView() {
        searchBar.onBackPressed {
            onBackPressed()
        }
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_search

}