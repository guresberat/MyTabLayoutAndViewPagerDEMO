package com.example.mytablayoutandviewpagerexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mytablayoutandviewpagerexercise.fragments.FavouritesFragment
import com.example.mytablayoutandviewpagerexercise.fragments.HomeFragment
import com.example.mytablayoutandviewpagerexercise.fragments.SettingsFragment
import com.example.mytablayoutandviewpagerexercise.fragments.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var demoCollectionAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.viewPager)

        setUp()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        }
        )
    }

    private fun setUp() {

        val fragmentManager = supportFragmentManager
        val lifecycle = lifecycle
        val fragments = ArrayList<Fragment>()
        val homeFragment = HomeFragment()
        val settingsFragment = SettingsFragment()
        val favFragment = FavouritesFragment()

        fragments.add(homeFragment)
        fragments.add(settingsFragment)
        fragments.add(favFragment)
        demoCollectionAdapter = ViewPagerAdapter(fragmentManager, lifecycle, fragments)
        viewPager.adapter = demoCollectionAdapter
        tabLayout.addTab(tabLayout.newTab().setText("Home"))
        tabLayout.addTab(tabLayout.newTab().setText("Settings"))
        tabLayout.addTab(tabLayout.newTab().setText("Favourites"))

        val tablistener = object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        }

        tabLayout.addOnTabSelectedListener(tablistener)

    }
}