package com.budge.hotdeal_go.presentation.view

import androidx.fragment.app.viewModels
import com.budge.hotdeal_go.R
import com.budge.hotdeal_go.databinding.FragmentLoginBinding
import com.budge.hotdeal_go.presentation.base.BaseFragment
import com.budge.hotdeal_go.presentation.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(
    FragmentLoginBinding::inflate,
    R.layout.fragment_login
) {

    private val viewModel : LoginViewModel by viewModels()

}