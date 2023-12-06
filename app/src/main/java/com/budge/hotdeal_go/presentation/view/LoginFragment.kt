package com.budge.hotdeal_go.presentation.view

import com.budge.hotdeal_go.R
import com.budge.hotdeal_go.databinding.FragmentLoginBinding
import com.budge.hotdeal_go.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(
    FragmentLoginBinding::inflate,
    R.layout.fragment_login
) {

}