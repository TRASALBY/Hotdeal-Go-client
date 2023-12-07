package com.budge.hotdeal_go.presentation.view

import android.os.Bundle
import android.view.Menu
import androidx.viewpager2.widget.ViewPager2
import com.budge.hotdeal_go.databinding.ActivityMainBinding
import com.budge.hotdeal_go.presentation.adapter.ViewPagerAdapter
import com.budge.hotdeal_go.presentation.base.BaseActivity
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewPager()
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
