package com.tom.baseandroid.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseAdapter
import com.tom.baseandroid.data.model.DataProduct
import com.tom.baseandroid.databinding.ItemProductBinding

/**
 *Created by VanTrang on 8/22/2019.
 */
class ProductAdapter : BaseAdapter() {
    private val mData: MutableList<DataProduct.Product> = mutableListOf()

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemProductBinding>(
            inflater,
            R.layout.item_product,
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindHolder(holder: RecyclerView.ViewHolder, position: Int) {
        mData[position].let { (holder as ProductViewHolder).bind(it) }
    }

    override fun getItemCount(): Int = mData.size

    inner class ProductViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(value: DataProduct.Product) = binding.apply {
            product = value
            image = value.image
        }
    }

    fun updateData(data: MutableList<DataProduct.Product>) {
        if (mData.isEmpty()) {
            mData.addAll(data)
            notifyDataSetChanged()
        }
        else {
            for (i in data.size - mData.size until data.size) {
                mData.add(data[i])
            }
            notifyItemInserted(mData.size)
        }
    }
}