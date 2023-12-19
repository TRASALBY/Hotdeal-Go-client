package com.budge.hotdeal_go.presentation.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.view.children
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.budge.hotdeal_go.databinding.ActivityMainBinding
import com.budge.hotdeal_go.presentation.adapter.ViewPagerAdapter
import com.budge.hotdeal_go.presentation.base.BaseActivity
import com.budge.hotdeal_go.presentation.viewmodel.MainViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val activityViewModel by viewModels<MainViewModel>()

    private val getLoginResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                activityViewModel.setLoginState(
                    result.data?.getBooleanExtra("LogInResult", false) ?: false
                )
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewPager()
        setFCM()
        setToolBar()
        setObserve()

    }

    private fun setFCM() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("FCM Log", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result.toString()

            // Log and toast
            Log.w("FCM Log", "Current Token = " + token)
        })
    }

    private fun setObserve() {
        activityViewModel.loginState.observe(this) { isLoggedIn ->
            binding.toolbarInMain.toolbar.menu[0].title = if (isLoggedIn) {
                "로그인 성공"
                // TODO 로그인 성공 시 유저 이름 구현하기
            } else {
                "로그인"
            }
        }
    }

    private fun setToolBar() {
        val intent = Intent(this, LoginActivity::class.java)
        binding.toolbarInMain.toolbar.menu.children.forEach {
            it.setOnMenuItemClickListener {
                getLoginResult.launch(intent)
                true
            }
        }
    }

    private fun initViewPager() {
        // adapter 세팅
        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPagerAdapter.addFragment(HomeFragment())
        viewPagerAdapter.addFragment(HotDealFragment())
        viewPagerAdapter.addFragment(NotificationFragment())
        viewPagerAdapter.addFragment(AnnouncementFragment())

        // adapter 연결
        binding.viewPager.apply {
            adapter = viewPagerAdapter

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })

        }

        // tablayout-viewpager 연결
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "홈"
                1 -> tab.text = "핫딜"
                2 -> tab.text = "알림"
                3 -> tab.text = "공지"
            }
        }.attach()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)

    }

}
