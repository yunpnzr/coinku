package com.cryptoapp.project_cryptoapp.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.cryptoapp.project_cryptoapp.data.model.Crypto
import com.cryptoapp.project_cryptoapp.databinding.CardItemBinding
import com.cryptoapp.project_cryptoapp.utils.toIndonesianFormat

interface ViewHolderBinder<T> {
    fun bind(item: T)
}

class CryptoViewHolder(
    private val binding: CardItemBinding,
    private val itemClick: (Crypto) -> Unit,
) : RecyclerView.ViewHolder(binding.root),
    ViewHolderBinder<Crypto> {
    override fun bind(item: Crypto) {
        item.let {
            binding.ivCoinImage.load(it.image) {
                crossfade(true)
            }
            binding.tvCoinName.text = it.name
            binding.tvCoinAbbreviation.text = it.symbol.uppercase()
            binding.tvCoinPrice.text = it.currentPrice.toIndonesianFormat()

            itemView.setOnClickListener {
                itemClick(item)
            }
        }
    }
}
