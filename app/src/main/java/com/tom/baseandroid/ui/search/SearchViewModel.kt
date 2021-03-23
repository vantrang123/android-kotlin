package com.tom.baseandroid.ui.search

import com.tom.baseandroid.base.BaseLoadMoreViewModel
import com.tom.baseandroid.data.model.DataProduct
import javax.inject.Inject

class SearchViewModel @Inject constructor() : BaseLoadMoreViewModel<DataProduct.Product>() {
    override fun loadMore() {
    }
}