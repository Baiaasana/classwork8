package com.example.classwork8.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.classwork8.R
import com.example.classwork8.StoreModel
import com.example.classwork8.databinding.SingleItemBinding
import com.example.classwork8.utility.setImage

class StoreAdapter :
    ListAdapter<StoreModel.Item, StoreAdapter.ItemViewHolder>(ItemCallback) {

    inner class ItemViewHolder(private val binding: SingleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item: StoreModel.Item = getItem(adapterPosition)
            binding.apply {
                setImage(item.cover.toString(), ivItem)
                tvPrice.text = item.price.toString()
                tvTitle.text = item.title.toString()
                if(item.liked == true){
                    ivFavourite.setImageResource(R.drawable.ic_baseline_favorite_24)
                }else{
                    ivFavourite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(SingleItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.bind()

    object ItemCallback : DiffUtil.ItemCallback<StoreModel.Item>() {
        override fun areItemsTheSame(
            oldItem: StoreModel.Item,
            newItem: StoreModel.Item,
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: StoreModel.Item,
            newItem: StoreModel.Item,
        ): Boolean {
            return oldItem == newItem
        }
    }
}