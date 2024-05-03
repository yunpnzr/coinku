package com.cryptoapp.project_cryptoapp.presentation.profile.edit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.cryptoapp.project_cryptoapp.R
import com.cryptoapp.project_cryptoapp.databinding.ActivityEditProfileBinding
import com.cryptoapp.project_cryptoapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditProfileActivity : AppCompatActivity() {
    private val binding: ActivityEditProfileBinding by lazy {
        ActivityEditProfileBinding.inflate(layoutInflater)
    }

    private val editProfileViewModel: EditProfileViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        showUser()
        setClickListener()
    }

    private fun setClickListener() {
        binding.btnChangePassword.setOnClickListener {
            editProfileViewModel.doChangePasswordByEmail()
            changePasswordRequest()
        }
        binding.btnConfirmEditProfile.setOnClickListener {
            val dialog =
                AlertDialog.Builder(this).setMessage(getString(R.string.account_identity_confirm))
                    .setPositiveButton(
                        getString(R.string.yes),
                    ) { _, _ ->
                        doChangeProfile()
                    }
                    .setNegativeButton(
                        getString(R.string.no),
                    ) { _, _ ->
                    }.create()
            dialog.show()
        }
    }

    private fun doChangeProfile() {
        val newName = binding.etNameEditProfile.text.toString()
        editProfileViewModel.doChangeProfile(newName).observe(this) {
            it.proceedWhen(
                doOnSuccess = {
                    binding.pbConfirmEditProfile.isVisible = false
                    binding.btnConfirmEditProfile.isEnabled = true
                    Toast.makeText(
                        this,
                        getString(R.string.change_name_success),
                        Toast.LENGTH_SHORT,
                    ).show()
                    finish()
                },
                doOnLoading = {
                    binding.pbConfirmEditProfile.isVisible = true
                    binding.btnConfirmEditProfile.isEnabled = false
                },
                doOnError = {
                    binding.pbConfirmEditProfile.isVisible = false
                    binding.btnConfirmEditProfile.isEnabled = true
                    Toast.makeText(
                        this,
                        getString(R.string.change_name_failed),
                        Toast.LENGTH_SHORT,
                    ).show()
                },
            )
        }
    }

    private fun changePasswordRequest() {
        val dialog =
            AlertDialog.Builder(this).setMessage(getString(R.string.change_password_alert))
                .setPositiveButton(
                    getString(R.string.yes),
                ) { _, _ ->
                }.create()
        dialog.show()
    }

    private fun showUser() {
        editProfileViewModel.getCurrentUser()?.let {
            binding.etNameEditProfile.setText(it.name)
            binding.etEmailEditProfile.setText(it.email)
        }
    }
}
