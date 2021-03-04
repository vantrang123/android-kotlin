package com.tom.baseandroid.ui.login

import androidx.navigation.fragment.findNavController
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseFragment
import com.tom.baseandroid.base.EmptyViewModel
import com.tom.baseandroid.databinding.FragmentSignUpBinding
import com.tom.baseandroid.di.injectViewModel
import com.tom.baseandroid.extensions.lauchActivity
import com.tom.baseandroid.ui.main.MainActivity
import com.tom.baseandroid.utils.Utils.hideKeyboard

class SignUpFragment : BaseFragment<FragmentSignUpBinding, EmptyViewModel>() {

    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<EmptyViewModel> = EmptyViewModel::class.java

    override fun initView() {
        binding.root.setOnClickListener {
            hideKeyboard(requireContext())
        }

        binding.btnSignUp.setOnClickListener {
            requireActivity().lauchActivity<MainActivity> {  }
            requireActivity().finish()
        }

        binding.toolbar.apply {
            setTitle(getString(R.string.sign_up_title))
            onBackPressed { findNavController().popBackStack(R.id.login_fragment, false) }
        }
    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_sign_up
}