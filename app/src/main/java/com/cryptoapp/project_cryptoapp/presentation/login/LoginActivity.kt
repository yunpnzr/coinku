package com.cryptoapp.project_cryptoapp.presentation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.cryptoapp.project_cryptoapp.R
import com.cryptoapp.project_cryptoapp.databinding.ActivityLoginBinding
import com.cryptoapp.project_cryptoapp.databinding.LayoutDialogBinding
import com.cryptoapp.project_cryptoapp.presentation.main.MainActivity
import com.cryptoapp.project_cryptoapp.presentation.register.RegisterActivity
import com.cryptoapp.project_cryptoapp.utils.hideKeyboard
import com.cryptoapp.project_cryptoapp.utils.proceedWhen
import com.google.android.material.textfield.TextInputLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setClickListeners()
    }

    private fun proceedLogin(
        email: String,
        password: String,
    ) {
        viewModel.doLogin(email = email, password = password).observe(this) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.pbLoadingLogin.isVisible = false
                    binding.btnLogin.isVisible = true
                    navigateToMain()
                },
                doOnError = {
                    binding.pbLoadingLogin.isVisible = false
                    binding.btnLogin.isVisible = true
                    Toast.makeText(
                        this,
                        "Login Failed : ${it.exception?.message.orEmpty()}",
                        Toast.LENGTH_SHORT,
                    ).show()
                },
                doOnLoading = {
                    binding.pbLoadingLogin.isVisible = true
                    binding.btnLogin.isVisible = false
                },
            )
        }
    }

    private fun navigateToMain() {
        startActivity(
            Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            },
        )
    }

    private fun setClickListeners() {
        binding.btnLogin.setOnClickListener {
            doLogin()
        }
        binding.tvNavToRegister.setOnClickListener {
            navigateToRegister()
        }
        binding.tvForgotPassword.setOnClickListener {
            setupInputRequest()
        }
        binding.btnSend.setOnClickListener {
            doSendRequest()
            hideKeyboard()
        }
    }

    private fun doSendRequest() {
        val email = binding.etEmail.text.toString().trim()
        if (checkEmailValidation(email)) {
            proceedSendRequest(email)
        }
    }

    private fun setupInputRequest() {
        binding.tvLoginTitle.isVisible = false
        binding.tvSendRequestTitle.isVisible = true
        binding.btnLogin.isVisible = false
        binding.btnSend.isVisible = true
        binding.etPassword.isVisible = false
        binding.tilPassword.isVisible = false
        binding.tvForgotPassword.isVisible = false
        binding.flNavToRegister.isVisible = false
    }

    private fun dialogSentRequest(context: Context) {
        val dialogBinding = LayoutDialogBinding.inflate(LayoutInflater.from(context))
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setView(dialogBinding.root)
        val dialog = alertDialogBuilder.create()
        dialogBinding.btnOkay.setOnClickListener {
            dialog.dismiss()
            setupInputLogin()
        }
        dialog.show()
    }

    private fun setupInputLogin() {
        binding.tvLoginTitle.isVisible = true
        binding.tvSendRequestTitle.isVisible = false
        binding.btnLogin.isVisible = true
        binding.btnSend.isVisible = false
        binding.tilPassword.isVisible = true
        binding.etPassword.isVisible = true
        binding.tvForgotPassword.isVisible = true
        binding.flNavToRegister.isVisible = true
        binding.etEmail.text?.clear()
    }

    private fun proceedSendRequest(email: String) {
        viewModel.requestChangePasswordByEmail(email = email).observe(this) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.pbLoadingLogin.isVisible = false
                    binding.btnSend.isVisible = true
                    dialogSentRequest(this)
                },
                doOnError = {
                    binding.pbLoadingLogin.isVisible = false
                    binding.btnLogin.isVisible = true
                    Toast.makeText(
                        this,
                        "Reset Failed : ${it.exception?.message.orEmpty()}",
                        Toast.LENGTH_SHORT,
                    ).show()
                },
                doOnLoading = {
                    binding.pbLoadingLogin.isVisible = true
                    binding.btnSend.isVisible = false
                    binding.btnLogin.isVisible = false
                },
            )
        }
    }

    private fun navigateToRegister() {
        startActivity(
            Intent(this, RegisterActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            },
        )
    }

    private fun doLogin() {
        if (isFormValid()) {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            proceedLogin(email = email, password = password)
        }
    }

    private fun isFormValid(): Boolean {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        return checkEmailValidation(email) &&
            checkPasswordValidation(password, binding.tilPassword)
    }

    private fun checkEmailValidation(email: String): Boolean {
        return if (email.isEmpty()) {
            binding.tilEmail.isErrorEnabled = true
            binding.tilEmail.error = getString(R.string.text_error_email_empty)
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.isErrorEnabled = true
            binding.tilEmail.error = getString(R.string.text_error_email_invalid)
            false
        } else {
            binding.tilEmail.isErrorEnabled = false
            true
        }
    }

    private fun checkPasswordValidation(
        confirmPassword: String,
        textInputLayout: TextInputLayout,
    ): Boolean {
        return if (confirmPassword.isEmpty()) {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error =
                getString(R.string.text_error_password_empty)
            false
        } else if (confirmPassword.length < 8) {
            textInputLayout.isErrorEnabled = true
            textInputLayout.error =
                getString(R.string.text_error_password_less_than_8_char)
            false
        } else {
            textInputLayout.isErrorEnabled = false
            true
        }
    }
}
