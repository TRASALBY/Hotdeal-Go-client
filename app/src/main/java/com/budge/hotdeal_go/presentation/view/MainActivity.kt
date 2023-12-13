package com.budge.hotdeal_go.presentation.view

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.core.view.children
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.budge.hotdeal_go.databinding.ActivityMainBinding
import com.budge.hotdeal_go.presentation.adapter.ViewPagerAdapter
import com.budge.hotdeal_go.presentation.base.BaseActivity
import com.budge.hotdeal_go.presentation.viewmodel.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val activityViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewPager()
        setToolBar()
        setObserve()
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
        binding.toolbarInMain.toolbar.menu.children.forEach {
            it.setOnMenuItemClickListener {
                //로그인 화면으로
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
