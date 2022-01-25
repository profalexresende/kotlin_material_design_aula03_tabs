package com.example.kotlin_material_design_aula02_tabs

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.kotlin_material_design_aula02_tabs.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Definindo cores de selecionado e não selecionado para as tabs
        binding.tabLayout.setSelectedTabIndicatorColor(Color.WHITE)
        binding.tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.design_default_color_primary_dark))
        binding.tabLayout.tabTextColors = ContextCompat.getColorStateList(this, android.R.color.white)


        // definindo o número de tabs
        val numberOfTabs = 3

        binding.tabLayout.tabMode = TabLayout.MODE_FIXED

        // Quando necessário, um scroll para ver todas as tabs
        //binding.tabLayout.tabMode = TabLayout.MODE_SCROLLABLE

        // Definindo os ícones ao lado do tab
        binding.tabLayout.isInlineLabel = true

        // Definindo o adaptador do viewPager
        val adapter = TabsPagerAdapter(supportFragmentManager, lifecycle, numberOfTabs)
        binding.tabsViewpager.adapter = adapter

        // Habilitando o deslizar
        binding.tabsViewpager.isUserInputEnabled = true

        // Link do tab com o viewpager
        TabLayoutMediator(binding.tabLayout, binding.tabsViewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Musica"
                    tab.setIcon(R.drawable.musica)
                }
                1 -> {
                    tab.text = "Filmes"
                    tab.setIcon(R.drawable.filme)

                }
                2 -> {
                    tab.text = "Livros"
                    tab.setIcon(R.drawable.livro)
                }
            }
        }.attach()
    }
}