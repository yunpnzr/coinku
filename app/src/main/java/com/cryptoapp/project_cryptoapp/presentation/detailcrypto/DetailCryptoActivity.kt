package com.cryptoapp.project_cryptoapp.presentation.detailcrypto

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import coil.load
import com.cryptoapp.project_cryptoapp.data.model.CryptoDetail
import com.cryptoapp.project_cryptoapp.databinding.ActivityDetailCryptoBinding
import com.cryptoapp.project_cryptoapp.utils.proceedWhen
import com.cryptoapp.project_cryptoapp.utils.toIndonesianFormat
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailCryptoActivity : AppCompatActivity() {
    private val binding: ActivityDetailCryptoBinding by lazy {
        ActivityDetailCryptoBinding.inflate(layoutInflater)
    }

    private val viewModel: DetailCryptoViewModel by viewModel {
        parametersOf(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.id?.let { setupDetailData(it) }
        setClickAction()
    }

    private fun setClickAction() {
        binding.ivBack.setOnClickListener {
            finish()
        }
        binding.btnOpenCoingecko.setOnClickListener {
            openLink()
        }
    }

    private fun openLink() {
        val url = viewModel.link
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun setupDetailData(id: String) {
        viewModel.getDetailCrypto(id).observe(this) {
            it.proceedWhen(
                doOnLoading = {
                    binding.layoutState.root.isVisible = true
                    binding.layoutState.pbLoading.isVisible = true
                    binding.layoutState.tvError.isVisible = false
                    binding.nvContent.isVisible = false
                    binding.cvBottomButton.isVisible = false
                },
                doOnSuccess = {
                    binding.layoutState.root.isVisible = false
                    binding.layoutState.pbLoading.isVisible = false
                    binding.layoutState.tvError.isVisible = false
                    binding.nvContent.isVisible = true
                    binding.cvBottomButton.isVisible = true
                    it.payload?.let { data -> bindDetailData(data) }
                },
                doOnError = {
                    binding.layoutState.root.isVisible = true
                    binding.layoutState.pbLoading.isVisible = false
                    binding.layoutState.tvError.isVisible = true
                    binding.layoutState.tvError.text = it.exception?.message.orEmpty()
                    binding.nvContent.isVisible = false
                    binding.cvBottomButton.isVisible = false
                },
            )
        }
    }

    private fun bindDetailData(crypto: CryptoDetail?) {
        crypto?.let { item ->
            binding.layoutItemDetailCoin.ivCoinImage.load(item.image) {
                crossfade(true)
            }
            binding.layoutItemDetailCoin.tvCoinName.text = item.name
            binding.layoutItemDetailCoin.tvCoinPrice.text = item.price.toIndonesianFormat()
            binding.tvCoinDescription.text = item.description
        }
    }

    companion object {
        const val ID_COIN = "ID_COIN"

        fun startActivity(
            context: Context,
            id: String,
        ) {
            val intent = Intent(context, DetailCryptoActivity::class.java)
            intent.putExtra(ID_COIN, id)
            context.startActivity(intent)
        }
    }
}
