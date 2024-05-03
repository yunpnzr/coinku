package com.cryptoapp.project_cryptoapp.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cryptoapp.project_cryptoapp.R
import com.cryptoapp.project_cryptoapp.databinding.FragmentProfileBinding
import com.cryptoapp.project_cryptoapp.presentation.login.LoginActivity
import com.cryptoapp.project_cryptoapp.presentation.profile.edit.EditProfileActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    private val profileViewModel: ProfileViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        showUser()
        setClickListener()
    }

    private fun setClickListener() {
        binding.btnLogoutProfile.setOnClickListener {
            doLogout()
        }
        binding.btnEditProfile.setOnClickListener {
            navigateToEdit()
        }
    }

    private fun navigateToEdit() {
        startActivity(
            Intent(requireContext(), EditProfileActivity::class.java),
        )
    }

    private fun showUser() {
        profileViewModel.getCurrentUser()?.let {
            binding.layoutHeaderProfile.tvNameProfile.text = it.name
            binding.layoutHeaderProfile.tvEmailProfile.text = it.email
        }
    }

    private fun doLogout() {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(getString(R.string.are_you_sure))
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                profileViewModel.doLogout()
                navigateToLogin()
            }
            .setNegativeButton(getString(R.string.no), null)
            .show()
    }

    private fun navigateToLogin() {
        startActivity(
            Intent(requireContext(), LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            },
        )
    }
}

