package com.cryptoapp.project_cryptoapp.presentation.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.cryptoapp.project_cryptoapp.R
import com.cryptoapp.project_cryptoapp.presentation.login.LoginActivity
import com.cryptoapp.project_cryptoapp.presentation.main.MainActivity
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroCustomLayoutFragment
import com.github.appintro.AppIntroPageTransformerType
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnboardingActivity : AppIntro() {
    private val onboardingViewModel: OnboardingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        slidePage()
        setTransformerOnboarding()
        setImmersiveMode()
        isWizardMode = true
        // onboardingViewModel.setFirstRun(true)
    }

    private fun slidePage() {
        slidePageOne()
        slidePageTwo()
        slidePageThree()
    }

    private fun slidePageThree() {
        addSlide(
            AppIntroCustomLayoutFragment.newInstance(
                R.layout.layout_onboarding_three,
            ),
        )
    }

    private fun slidePageTwo() {
        addSlide(
            AppIntroCustomLayoutFragment.newInstance(
                R.layout.layout_onboarding_two,
            ),
        )
    }

    private fun slidePageOne() {
        addSlide(
            AppIntroCustomLayoutFragment.newInstance(
                R.layout.layout_onboarding_one,
            ),
        )
    }

    private fun setTransformerOnboarding() {
        setTransformer(
            AppIntroPageTransformerType
                .Parallax(
                    titleParallaxFactor = 1.0,
                    imageParallaxFactor = -1.0,
                    descriptionParallaxFactor = 2.0,
                ),
        )
    }

    public override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // navigateToLogin()
        checkAuth()
    }

    public override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // navigateToLogin()
        checkAuth()
    }

    private fun checkAuth() {
        if (onboardingViewModel.isLogin()) {
            navigateToMain()
        } else {
            navigateToLogin()
        }
    }

    private fun navigateToMain() {
        startActivity(
            Intent(this, MainActivity::class.java).apply {
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
}
