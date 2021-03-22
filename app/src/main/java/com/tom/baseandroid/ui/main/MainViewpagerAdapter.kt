package com.tom.baseandroid.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseFragment
import com.tom.baseandroid.ui.account.AccountFragment
import com.tom.baseandroid.ui.home.*
import com.tom.baseandroid.ui.livestream.LiveStreamFragment
import com.tom.baseandroid.ui.newfeed.NewFeedFragment
import com.tom.baseandroid.ui.notification.NotificationFragment
import kotlinx.android.synthetic.main.tab_main.view.*

/**
 *Created by VanTrang.
 */
class MainViewpagerAdapter(
    private val context: Context,
    private val fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = fragments.size

    override
    fun getItem(position: Int): Fragment = fragments[position]

    private val fragments = arrayListOf<BaseFragment<*, *>>(
        HomeFragment(),
        NewFeedFragment(),
        LiveStreamFragment(),
        NotificationFragment(),
        AccountFragment()
    )

    private val imageResId =
        intArrayOf(
            R.color.selector_icon_home,
            R.drawable.ic_new_feed,
            R.drawable.ic_live_steam,
            R.drawable.ic_notifications,
            R.drawable.ic_account
        )

    private val titles = context.resources.getStringArray(R.array.title_viewpager_main)

    fun getTabView(position: Int): View {
        val v = LayoutInflater.from(context).inflate(R.layout.tab_main, null)
        v.tvTitle.text = titles[position]
        v.image.setImageResource(imageResId[position])
        return v
    }
}