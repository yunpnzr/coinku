package com.cryptoapp.project_cryptoapp.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cryptoapp.project_cryptoapp.R
import com.cryptoapp.project_cryptoapp.databinding.ActivityMainBinding
import com.cryptoapp.project_cryptoapp.presentation.home.HomeFragment
import com.cryptoapp.project_cryptoapp.presentation.profile.ProfileFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        openMainFragment()
        supportActionBar?.hide()
        setupBottomNav()
    }

    private fun openMainFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frag_container_nav, HomeFragment())
        transaction.commit()
    }

    private fun setupBottomNav() {
        val menu_bottom = findViewById<ChipNavigationBar>(R.id.nav_view)
        menu_bottom.setItemSelected(R.id.menu_tab_home)

        menu_bottom.setOnItemSelectedListener {
            when (it) {
                R.id.menu_tab_home -> {
                    openMainFragment()
                }

                /*R.id.menu_tab_favorite -> {
                    val favoriteFragment = FavoriteFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frag_container_nav, favoriteFragment).commit()
                }*/

                R.id.menu_tab_profile -> {
                    val profileFragment = ProfileFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frag_container_nav, profileFragment).commit()
                }
            }
        }
    }
}
