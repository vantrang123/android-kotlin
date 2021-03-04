package com.rikai.baseandroid.ui.main

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rikai.baseandroid.R
import com.rikai.baseandroid.base.BaseActivity
import com.rikai.baseandroid.data.model.Player
import com.rikai.baseandroid.databinding.ActivityMainBinding
import com.rikai.baseandroid.di.injectViewModel
import com.rikai.baseandroid.extensions.visible

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    private lateinit var adapter: MainAdapter

    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun initView() {
        adapter = MainAdapter(this::onItemClicked)

        binding.recyclerView.layoutManager =
                LinearLayoutManager(
                        this, LinearLayoutManager.VERTICAL,
                        false
                )

        binding.adapter = adapter
        initViewModel()
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.apply {
            getListPlayers()
            players.observe(this@MainActivity, Observer {
                adapter.setPlayerList(it)
                binding.recyclerView.visible()
            })
        }
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_main

    private fun onItemClicked(player: Player) {
        snackBar("Click ${player.firstName + player.lastName}")
    }

    override fun onBackPressed() {
        moveTaskToBack(false)
    }
}