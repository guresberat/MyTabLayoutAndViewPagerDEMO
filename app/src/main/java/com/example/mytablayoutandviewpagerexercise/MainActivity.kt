package com.example.mytablayoutandviewpagerexercise

import android.graphics.Color
import android.graphics.PorterDuff
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
        tabLayout.addTab(tabLayout.newTab().setText("Home").setIcon(R.drawable.ic_baseline_home_24))
        tabLayout.addTab(tabLayout.newTab().setText("Settings").setIcon(R.drawable.ic_baseline_settings_24))
        tabLayout.addTab(tabLayout.newTab().setText("Favourites").setIcon(R.drawable.ic_baseline_favorite_24))

        tabLayout.getTabAt(0)?.icon?.setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1)?.icon?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2)?.icon?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);


        setUp()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
                tabLayout.getTabAt(position)?.icon?.setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
            }


        }

        )
    }

    private fun setUp() {

        val tablistener = object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    tab.icon?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        }
        tabLayout.addOnTabSelectedListener(tablistener)

    }
}