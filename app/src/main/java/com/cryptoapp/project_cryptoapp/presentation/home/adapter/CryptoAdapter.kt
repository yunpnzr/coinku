package com.cryptoapp.project_cryptoapp.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cryptoapp.project_cryptoapp.data.model.Crypto
import com.cryptoapp.project_cryptoapp.databinding.CardItemBinding

class CryptoAdapter(
    private val itemClick: (Crypto) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var asyncDataDiffer =
        AsyncListDiffer(
            this,
            object : DiffUtil.ItemCallback<Crypto>() {
                override fun areItemsTheSame(
                    oldItem: Crypto,
                    newItem: Crypto,
                ): Boolean {
                    return oldItem.name == newItem.name
                }

                override fun areContentsTheSame(
                    oldItem: Crypto,
                    newItem: Crypto,
                ): Boolean {
                    return oldItem.hashCode() == oldItem.hashCode()
                }
            },
        )

    fun submitData(data: List<Crypto>) {
        asyncDataDiffer.submitList(data)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerView.ViewHolder {
        return CryptoViewHolder(
            CardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            itemClick,
        )
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
    ) {
        when (holder) {
            is CryptoViewHolder -> holder.bind(asyncDataDiffer.currentList[position])
        }
    }

    override fun getItemCount(): Int = asyncDataDiffer.currentList.size
}
