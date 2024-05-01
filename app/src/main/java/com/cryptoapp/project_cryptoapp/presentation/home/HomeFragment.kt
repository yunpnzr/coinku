package com.cryptoapp.project_cryptoapp.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.cryptoapp.project_cryptoapp.R
import com.cryptoapp.project_cryptoapp.data.model.Crypto
import com.cryptoapp.project_cryptoapp.databinding.FragmentHomeBinding
import com.cryptoapp.project_cryptoapp.presentation.home.adapter.CryptoAdapter
import com.cryptoapp.project_cryptoapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by viewModel()

    private val cryptoAdapter: CryptoAdapter by lazy {
        CryptoAdapter {
            navigateToDetail(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        setUserName()
        setupMenu()
        getListCrypto("idr")
    }

    private fun setUserName() {
        val username =
            if (homeViewModel.isLoggedIn()) homeViewModel.getCurrentUser()?.name else "Guest"
        binding.layoutBanner.tvTitleBanner.text = getString(R.string.hi_username, username)
    }

    private fun setupMenu() {
        binding.rvMenuList.apply {
            adapter = cryptoAdapter
        }
    }

    private fun getListCrypto(vsCurrency: String = "idr") {
        homeViewModel.getListCrypto(vsCurrency).observe(viewLifecycleOwner) { crypto ->
            crypto.proceedWhen(
                doOnSuccess = {
                    binding.layoutState.root.isVisible = false
                    binding.layoutState.pbLoading.isVisible = false
                    crypto.payload?.let { data ->
                        bindListCrypto(data)
                    }
                },
                doOnError = {
                    Log.e("Error Binding List Crypto", it.message.toString())
                    binding.layoutState.root.isVisible = false
                    binding.layoutState.pbLoading.isVisible = false
                    Toast.makeText(requireContext(), "Failed Bind List Crypto", Toast.LENGTH_SHORT)
                        .show()
                },
                doOnLoading = {
                    binding.layoutState.root.isVisible = true
                    binding.layoutState.pbLoading.isVisible = true
                },
            )
        }
    }

    private fun bindListCrypto(data: List<Crypto>) {
        cryptoAdapter.submitData(data)
    }

    private fun navigateToDetail(item: Crypto) {
//        DetailMenuActivity.startActivity(requireContext(), item)
    }
}
