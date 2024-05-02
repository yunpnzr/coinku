package com.cryptoapp.project_cryptoapp.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.cryptoapp.project_cryptoapp.databinding.ActivitySplashBinding
import com.cryptoapp.project_cryptoapp.presentation.login.LoginActivity
import com.cryptoapp.project_cryptoapp.presentation.main.MainActivity
import com.cryptoapp.project_cryptoapp.presentation.onboarding.OnboardingActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {
    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }
    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSplashScreen()
    }

    private fun checkLogin() {
        if (!viewModel.isLogin()) navigateToLogin() else navigateToMain()
    }

    private fun checkOnboarding() {
        if (!viewModel.isFirstRun()) {
            navigateToOnBoarding()
            viewModel.setFirstRun(true)
        } else {
            checkLogin()
        }
    }

    private fun navigateToOnBoarding() {
        startActivity(
            Intent(this, OnboardingActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            },
        )
    }

    private fun navigateToLogin() {
        startActivity(
            Intent(this, LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            },
        )
    }

    private fun setSplashScreen() {
        lifecycleScope.launch {
            delay(2000)
            // checkLogin()
            checkOnboarding()
        }
    }

    private fun navigateToMain() {
        startActivity(
            Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            },
        )
    }
}
