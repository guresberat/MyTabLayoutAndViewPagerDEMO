package com.example.mytablayoutandviewpagerexercise.fragments.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mytablayoutandviewpagerexercise.MainActivity
import com.example.mytablayoutandviewpagerexercise.fragments.HomeFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val fragments: ArrayList<Fragment>
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}