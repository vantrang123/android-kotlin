package com.tom.baseandroid.ui.login

import androidx.navigation.fragment.findNavController
import com.jakewharton.rxbinding2.widget.RxTextView
import com.tom.baseandroid.R
import com.tom.baseandroid.base.BaseFragment
import com.tom.baseandroid.base.EmptyViewModel
import com.tom.baseandroid.databinding.FragmentLoginBinding
import com.tom.baseandroid.di.injectViewModel
import com.tom.baseandroid.extensions.lauchActivity
import com.tom.baseandroid.ui.main.MainActivity
import com.tom.baseandroid.utils.Utils.hideKeyboard
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.addTo

class LoginFragment : BaseFragment<FragmentLoginBinding, EmptyViewModel>() {
    private val compositeDisposable = CompositeDisposable()

    override fun injectViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getViewModelClass(): Class<EmptyViewModel> = EmptyViewModel::class.java

    override fun getLayoutResourceId(): Int = R.layout.fragment_login

    override fun initView() {
        binding.apply {

            // Navigate to sign up fragment
            tvSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_login_fragment_to_sign_up_fragment)
            }

            btnLogin.setOnClickListener {
                requireActivity().lauchActivity<MainActivity> {  }
                requireActivity().finish()
            }

            edtPassword.apply {
                setOnEditorActionListener { _, _, _ ->
                    hideKeyboard(requireContext())
                    doLogin()
                    true
                }
            }

            root.setOnClickListener { hideKeyboard(requireContext()) }
        }

        obsInput()
    }

    private fun doLogin() {
        binding.apply {
            snackBar("Do Login!")
        }
    }

    private fun obsInput() {
        Observables.combineLatest(
                RxTextView.textChanges(binding.edtEmail),
                RxTextView.textChanges(binding.edtPassword)
        ) { email, password ->
            email.isNotEmpty() && password.isNotEmpty() && password.length >= 6
        }.subscribe {
            binding.btnLogin.apply {
                isEnabled = it
                alpha = if (it) 1.0f else 0.5f
            }
        }.addTo(compositeDisposable)
    }

    private fun getParentViewModel(): LoginViewModel {
        return (activity as? LoginActivity)?.viewModel ?: LoginViewModel()
    }
}