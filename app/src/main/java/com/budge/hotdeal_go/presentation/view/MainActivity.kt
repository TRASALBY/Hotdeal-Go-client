package com.budge.hotdeal_go.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.budge.hotdeal_go.R
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor(
    private val retrofit: Retrofit,
) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
