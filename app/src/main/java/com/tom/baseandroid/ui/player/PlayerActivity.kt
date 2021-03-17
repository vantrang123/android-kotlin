package com.tom.baseandroid.ui.player

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseActivity
import com.tom.baseandroid.data.model.Player
import com.tom.baseandroid.data.network.NetworkConnectionLiveData
import com.tom.baseandroid.databinding.ActivityPlayerBinding
import com.tom.baseandroid.di.injectViewModel
import com.tom.baseandroid.extensions.visible

class PlayerActivity : BaseActivity<ActivityPlayerBinding, PlayerViewModel>() {
    private lateinit var adapter: MainAdapter

    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<PlayerViewModel> = PlayerViewModel::class.java

    override fun initView() {
        adapter = MainAdapter(this::onItemClicked)

        binding.recyclerView.layoutManager =
                LinearLayoutManager(
                        this, LinearLayoutManager.VERTICAL,
                        false
                )

        binding.toolbar.apply {
            onBackPressed {
                onBackPressed()
            }
            setTitle(getString(R.string.main_title))
        }

        binding.adapter = adapter
        initViewModel()
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.apply {
            players.observe(this@PlayerActivity, Observer {
                adapter.setPlayerList(it)
                binding.recyclerView.visible()
            })
            NetworkConnectionLiveData(this@PlayerActivity)
                .observe(this@PlayerActivity, Observer { isConnected ->
                    if (isConnected && players.value.isNullOrEmpty()) getListPlayers()
                })
        }
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_player

    private fun onItemClicked(player: Player) {
        snackBar("Click ${player.firstName + player.lastName}")
    }

    override fun onBackPressed() {
        moveTaskToBack(false)
    }
}