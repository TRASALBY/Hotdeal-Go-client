package com.budge.hotdeal_go.presentation.view

import android.os.Bundle
import com.budge.hotdeal_go.R
import com.budge.hotdeal_go.databinding.ActivityLoginBinding
import com.budge.hotdeal_go.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_login, LoginFragment())
            .commit()
    }

}