package com.tom.baseandroid.ui.main

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseActivity
import com.tom.baseandroid.data.model.Player
import com.tom.baseandroid.data.network.NetworkConnectionLiveData
import com.tom.baseandroid.databinding.ActivityMainBinding
import com.tom.baseandroid.di.injectViewModel
import com.tom.baseandroid.extensions.visible

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

        binding.toolbar.apply {
            onBackPressed {
                moveTaskToBack(false)
            }
            setTitle(getString(R.string.main_title))
        }
        binding.toolbar.onBackPressed {
            moveTaskToBack(false)
        }

        binding.adapter = adapter
        initViewModel()
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.apply {
            players.observe(this@MainActivity, Observer {
                adapter.setPlayerList(it)
                binding.recyclerView.visible()
            })
            NetworkConnectionLiveData(this@MainActivity)
                .observe(this@MainActivity, Observer { isConnected ->
                    if (isConnected) getListPlayers()
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