package com.tom.baseandroid.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseAdapter
import com.tom.baseandroid.data.model.DataCategory
import com.tom.baseandroid.databinding.ItemCategotyBinding
import com.tom.baseandroid.extensions.getDefault

/**
 *Created by VanTrang.
 */
class CategoryAdapter : BaseAdapter() {
    private val mDataCategory: MutableList<DataCategory.Category> = mutableListOf()

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemCategotyBinding>(
                inflater,
                R.layout.item_categoty,
                parent,
                false
            )
        return CategoryViewHolder(
            binding
        )
    }

    override fun onBindHolder(holder: RecyclerView.ViewHolder, position: Int) {
        mDataCategory[position].let { (holder as CategoryViewHolder).bind(it) }
    }

    override fun getItemCount(): Int = mDataCategory.size.getDefault()

    inner class CategoryViewHolder(var binding: ItemCategotyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(value: DataCategory.Category) = binding.apply {
            category = value
            imageCircle = value.main?.imageUrl
        }
    }

    fun updateData(dataCategory: MutableList<DataCategory.Category>) {
        mDataCategory.clear()
        mDataCategory.addAll(dataCategory)
        notifyDataSetChanged()
    }
}