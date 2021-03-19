package com.tom.baseandroid.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tom.baseandroid.R
import com.tom.baseandroid.utils.LoadingViewHolder
import com.tom.baseandroid.utils.NetworkState

/**
 *Created by VanTrang.
 */
abstract class BaseAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var networkState: NetworkState? = null

    override fun getItemViewType(position: Int) =
        if (hasExtraRow() && position == itemCount - 1) {
            ViewType.ITEM_LOADING.type
        } else {
            ViewType.ITEM_NORMAL_LIST.type
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.ITEM_LOADING.type -> LoadingViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_loading, parent, false
                )
            )
            else -> getViewHolder(parent, viewType)
        }
    }

    abstract fun getViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LoadingViewHolder -> holder.bindData()
            else -> onBindHolder(holder, position)
        }
    }

    abstract fun onBindHolder(holder: RecyclerView.ViewHolder, position: Int)

    fun hasExtraRow() = networkState != null && networkState != NetworkState.LOADED

    fun setNetworkState(newNetworkState: NetworkState?) {
        val previousState = this.networkState
        val hadExtraRow = hasExtraRow()
        this.networkState = newNetworkState
        val hasExtraRow = hasExtraRow()
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(itemCount)
            } else {
                notifyItemInserted(itemCount)
            }
        } else if (hasExtraRow && previousState != newNetworkState) {
            notifyItemChanged(itemCount - 1)
        }
    }

    enum class ViewType(val type: Int) {
        ITEM_NORMAL_LIST(0), ITEM_LOADING(-1), ITEM_SPECIAL_LIST(-2)
    }
}
