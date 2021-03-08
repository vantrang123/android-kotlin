package com.tom.baseandroid.ui.login

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseFragment
import com.tom.baseandroid.base.EmptyViewModel
import com.tom.baseandroid.data.model.User
import com.tom.baseandroid.databinding.FragmentSignUpBinding
import com.tom.baseandroid.di.injectViewModel
import com.tom.baseandroid.extensions.lauchActivity
import com.tom.baseandroid.preference.IConfigurationPrefs
import com.tom.baseandroid.ui.main.MainActivity
import com.tom.baseandroid.utils.Utils.hideKeyboard
import javax.inject.Inject

class SignUpFragment : BaseFragment<FragmentSignUpBinding, EmptyViewModel>() {
    @Inject
    lateinit var prefs: IConfigurationPrefs

    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<EmptyViewModel> = EmptyViewModel::class.java

    override fun initView() {
        binding.apply {
            root.setOnClickListener {
                hideKeyboard(requireContext())
            }
            btnSignUp.setOnClickListener {
                val user = User().apply {
                    email = edtEmail.text.toString()
                    password = edtPassword.text.toString()
                }
                getParentViewModel()?.saveAccount(user)
            }
            toolbar.apply {
                setTitle(getString(R.string.sign_up_title))
                onBackPressed { findNavController().popBackStack(R.id.login_fragment, false) }
            }
            edtPassword.apply {
                setOnEditorActionListener { _, _, _ ->
                    hideKeyboard(requireContext())
                    btnSignUp.performClick()
                    true
                }
            }
        }
        initViewModel()
    }

    override fun initViewModel() {
        super.initViewModel()
        getParentViewModel()?.signUpResult?.observe(viewLifecycleOwner, Observer {
            if (it.second) {
                prefs.user = it.first!!
                requireActivity().lauchActivity<MainActivity> {  }
                requireActivity().finish()
            }
        })
    }

    override fun getLayoutResourceId(): Int = R.layout.fragment_sign_up

    private fun getParentViewModel(): LoginViewModel? {
        return (activity as? LoginActivity)?.viewModel
    }
}