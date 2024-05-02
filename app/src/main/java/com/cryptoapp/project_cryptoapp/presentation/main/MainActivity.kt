package com.cryptoapp.project_cryptoapp.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cryptoapp.project_cryptoapp.R
import com.cryptoapp.project_cryptoapp.databinding.ActivityMainBinding
import com.cryptoapp.project_cryptoapp.presentation.login.LoginActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupBottomNav()
    }

    private fun setupBottomNav() {
        val navController = findNavController(R.id.main_nav_host)
        binding.navView.setupWithNavController(navController)

//        navController.addOnDestinationChangedListener { controller, destination, args ->
//            when (destination.id) {
//                R.id.menu_tab_profile -> {
//                    if(!mainViewModel.isLoggedIn()){
//                        navigateToLogin()
//                        controller.popBackStack(R.id.menu_tab_home, false)
//                    }
//                }
//            }
//        }
    }

    private fun navigateToLogin() {
        startActivity(
            Intent(this, LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            },
        )
    }
}
