package com.cryptoapp.project_cryptoapp.presentation.favorite

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.cryptoapp.project_cryptoapp.data.model.Crypto
import com.cryptoapp.project_cryptoapp.databinding.FragmentFavoriteBinding
import com.cryptoapp.project_cryptoapp.presentation.detailcrypto.DetailCryptoActivity
import com.cryptoapp.project_cryptoapp.presentation.home.adapter.CryptoAdapter
import com.cryptoapp.project_cryptoapp.utils.proceedWhen
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    private val cryptoAdapter: CryptoAdapter by lazy {
        CryptoAdapter {
            it.id?.let { it1 -> navigateToDetail(it1) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        setupMenu()
        getListCrypto("idr")
    }

    private fun setupMenu() {
        binding.rvMenuList.apply {
            adapter = cryptoAdapter
        }
    }

    private fun getListCrypto(vsCurrency: String = "idr") {
        favoriteViewModel.getListCrypto(vsCurrency).observe(viewLifecycleOwner) { crypto ->
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

    private fun navigateToDetail(id: String) {
        DetailCryptoActivity.startActivity(requireContext(), id)
    }
}
