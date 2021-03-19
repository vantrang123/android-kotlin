package com.tom.baseandroid.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseAdapter
import com.tom.baseandroid.data.model.Data
import com.tom.baseandroid.extensions.getDefault
import kotlinx.android.synthetic.main.item_categoty.view.*

/**
 *Created by VanTrang.
 */
class CategoryAdapter : BaseAdapter() {
    private val mCategories: MutableList<Data.Category> = mutableListOf()

    override fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_categoty,
                parent,
                false
            )
        )
    }

    override fun onBindHolder(holder: RecyclerView.ViewHolder, position: Int) {
        mCategories[position].let { (holder as CategoryViewHolder).bind(it) }
    }

    override fun getItemCount(): Int = mCategories.size.getDefault()

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(value: Data.Category) {
            with(itemView) {
                Glide.with(context)
                    .load(value.main?.imageUrl)
                    .placeholder(R.color.gray_chalice)
                    .error(R.color.gray_chalice)
                    .into(ivImage)

                tvName.text = value.main?.categoryDisplayName
            }
        }
    }

    fun updateData(data: MutableList<Data.Category>) {
        mCategories.clear()
        mCategories.addAll(data)
        notifyDataSetChanged()
    }
}