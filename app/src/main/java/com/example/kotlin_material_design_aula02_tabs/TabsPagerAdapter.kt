package com.example.kotlin_material_design_aula02_tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int) : FragmentStateAdapter(fm, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                val fragmento = fragmentoMusica()
                return fragmento
            }
            1 -> {
                val fragmento = fragmentoFilme()
                return fragmento
            }

            else -> return fragmentoLivro()
        }
    }

    override fun getItemCount(): Int {
        return numberOfTabs
    }
}