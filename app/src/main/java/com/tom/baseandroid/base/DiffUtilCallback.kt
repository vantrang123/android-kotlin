package com.tom.baseandroid.base

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallback<in T>(private val mOldItems: List<T>,
                             private val mNewItems: List<T>,
                             private val mComparator: ItemComparator<T>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return mOldItems.size
    }

    override fun getNewListSize(): Int {
        return mNewItems.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = if (oldItemPosition < mOldItems.size) mOldItems[oldItemPosition] else null
        val newItem = if (newItemPosition < mNewItems.size) mNewItems[newItemPosition] else null
        return oldItem != null && newItem != null && mComparator.areItemsTheSame(oldItem,
                newItem)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = if (oldItemPosition < mOldItems.size) mOldItems[oldItemPosition] else null
        val newItem = if (newItemPosition < mNewItems.size) mNewItems[newItemPosition] else null
        return oldItem != null && newItem != null && mComparator.areContentsTheSame(mOldItems[oldItemPosition],
                mNewItems[newItemPosition])
    }

    @Nullable
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}