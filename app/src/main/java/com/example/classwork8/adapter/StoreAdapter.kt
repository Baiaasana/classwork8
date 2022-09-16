package com.example.classwork8.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.classwork8.R
import com.example.classwork8.data.StoreModel
import com.example.classwork8.databinding.SingleItemBinding
import com.example.classwork8.utility.setImage

class StoreAdapter :
    ListAdapter<StoreModel, StoreAdapter.ItemViewHolder>(ItemCallback) {

    var itemClick: ((StoreModel) -> Unit)? = null

    inner class ItemViewHolder(private val binding: SingleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ResourceAsColor")
        fun bind() {
            val item: StoreModel = getItem(adapterPosition)
            binding.apply {
                setImage(item.cover.toString(), ivItem)
                tvPrice.text = item.price.toString()
                tvTitle.text = item.title.toString()
                if (item.liked == true) {
                    ivFavourite.setImageResource(R.drawable.ic_baseline_favorite_24)
                } else {
                    ivFavourite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }
                btnBuy.setOnClickListener {
                    itemClick?.invoke(item)
                    ivBasket.setImageResource(R.drawable.ic_baseline_shopping_basket_green)
                    soldOut.isVisible = true
                    btnBuy.isEnabled = false
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(SingleItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind()

    object ItemCallback : DiffUtil.ItemCallback<StoreModel>() {
        override fun areItemsTheSame(
            oldItem: StoreModel,
            newItem: StoreModel,
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: StoreModel,
            newItem: StoreModel,
        ): Boolean {
            return oldItem == newItem
        }
    }
}