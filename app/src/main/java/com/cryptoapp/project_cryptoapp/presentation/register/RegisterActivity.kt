package com.cryptoapp.project_cryptoapp.presentation.register

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.cryptoapp.project_cryptoapp.R
import com.cryptoapp.project_cryptoapp.databinding.ActivityRegisterBinding
import com.cryptoapp.project_cryptoapp.presentation.login.LoginActivity
import com.cryptoapp.project_cryptoapp.utils.proceedWhen
import com.google.android.material.textfield.TextInputLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {
    private val binding: ActivityRegisterBinding by lazy {
        ActivityRegisterBinding.inflate(layoutInflater)
    }

    private val registerViewModel: RegisterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setClickListener()
    }

    private fun setClickListener() {
        binding.layoutInputRegister.btnRegister.setOnClickListener {
            doRegister()
        }

        binding.layoutInputRegister.tvHaveAccount.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        startActivity(
            Intent(this, LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            },
        )
    }

    private fun doRegister() {
        if (isFormValid()) {
            val name = binding.layoutInputRegister.etNameRegister.text.toString().trim()
            val email = binding.layoutInputRegister.etEmailRegister.text.toString().trim()
            val password = binding.layoutInputRegister.etPasswordRegister.text.toString().trim()
            proceedRegister(name, email, password)
        }
    }

    private fun proceedRegister(
        name: String,
        email: String,
        password: String,
    ) {
        registerViewModel.doRegister(name, email, password).observe(this) { result ->
            result.proceedWhen(
                doOnSuccess = {
                    binding.layoutInputRegister.pbRegister.isVisible = false
                    binding.layoutInputRegister.btnRegister.isEnabled = true
                    val dialog =
                        AlertDialog.Builder(this).setMessage(getString(R.string.registration_success))
                            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                                navigateToLogin()
                            }
                    dialog.show()
                },
                doOnLoading = {
                    binding.layoutInputRegister.pbRegister.isVisible = true
                    binding.layoutInputRegister.btnRegister.isEnabled = false
                },
                doOnError = {
                    binding.layoutInputRegister.pbRegister.isVisible = false
                    binding.layoutInputRegister.btnRegister.isEnabled = true
                    val dialog =
                        AlertDialog.Builder(this).setMessage(getString(R.string.registration_failed))
                            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                            }
                    dialog.show()
                },
            )
        }
    }

    private fun isFormValid(): Boolean {
        val name = binding.layoutInputRegister.etNameRegister.text.toString().trim()
        val email = binding.layoutInputRegister.etEmailRegister.text.toString().trim()
        val password = binding.layoutInputRegister.etPasswordRegister.text.toString().trim()
        val confirmPassword = binding.layoutInputRegister.etConfirmPasswordRegister.text.toString().trim()

        return checkNameValidation(name) &&
            checkEmailValidation(email) &&
            checkPasswordValidation(password, binding.layoutInputRegister.edPasswordRegister) &&
            checkPasswordValidation(confirmPassword, binding.layoutInputRegister.edConfirmPasswordRegister) &&
            checkPasswordAndConfirmPassword(password, confirmPassword)
    }

    private fun checkPasswordAndConfirmPassword(
        password: String,
        confirmPassword: String,
    ): Boolean {
        return if (password != confirmPassword) {
            binding.layoutInputRegister.edPasswordRegister.isErrorEnabled = true
            binding.layoutInputRegister.edPasswordRegister.error = getString(R.string.password_not_same)
            binding.layoutInputRegister.edConfirmPasswordRegister.isErrorEnabled = true
            binding.layoutInputRegister.edConfirmPasswordRegister.error = getString(R.string.password_not_same)
            false
        } else {
            binding.layoutInputRegister.edPasswordRegister.isErrorEnabled = false
            binding.layoutInputRegister.edConfirmPasswordRegister.isErrorEnabled = false
            true
        }
    }

    private fun checkPasswordValidation(
        password: String,
        edPasswordRegister: TextInputLayout,
    ): Boolean {
        return if (password.isEmpty()) {
            edPasswordRegister.isErrorEnabled = true
            edPasswordRegister.error = getString(R.string.password_not_empty)
            false
        } else if (password.length < 8) {
            edPasswordRegister.isErrorEnabled = true
            edPasswordRegister.error = getString(R.string.password_under_character)
            false
        } else {
            edPasswordRegister.isErrorEnabled = false
            true
        }
    }

    private fun checkEmailValidation(email: String): Boolean {
        return if (email.isEmpty()) {
            binding.layoutInputRegister.edEmailRegister.isErrorEnabled = true
            binding.layoutInputRegister.edEmailRegister.error = getString(R.string.email_is_empty)
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.layoutInputRegister.edEmailRegister.isErrorEnabled = true
            binding.layoutInputRegister.edEmailRegister.error = getString(R.string.email_invalid)
            false
        } else {
            binding.layoutInputRegister.edEmailRegister.isErrorEnabled = false
            true
        }
    }

    private fun checkNameValidation(name: String): Boolean {
        return if (name.isEmpty()) {
            binding.layoutInputRegister.edNameRegister.isErrorEnabled = true
            binding.layoutInputRegister.edNameRegister.error = getString(R.string.name_is_empty)
            false
        } else {
            binding.layoutInputRegister.edNameRegister.isErrorEnabled = false
            true
        }
    }
}
