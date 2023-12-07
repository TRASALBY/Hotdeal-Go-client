package com.budge.hotdeal_go.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.budge.hotdeal_go.data.model.HotDealItem
import com.budge.hotdeal_go.databinding.ItemHotdealBinding

class HotDealRecyclerViewAdapter(
    private val itemClick: (HotDealItem) -> (Unit)
) : ListAdapter<HotDealItem, HotDealRecyclerViewAdapter.HotDealViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotDealViewHolder {
        val binding = ItemHotdealBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotDealViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: HotDealViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: List<HotDealItem>?) {
        super.submitList(list)
    }


    inner class HotDealViewHolder(
        private val binding: ItemHotdealBinding,
        private val itemClick: (HotDealItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        lateinit var hotDealItem: HotDealItem

        init {
            itemView.setOnClickListener { itemClick(hotDealItem) }
        }

        fun bind(hotDealItem: HotDealItem) {
            this.hotDealItem = hotDealItem
            binding.hotDealTitle.text = hotDealItem.title
            binding.hotDealShoppingMall.text = hotDealItem.purchasingPlace
            binding.hotDealCost.text = hotDealItem.price
            binding.hotDealLikeCnt.text = hotDealItem.likeCnt.toString()
            binding.hotDealDeliveryFee.text = hotDealItem.shippingFee
            binding.hotDealWriteDate.text = hotDealItem.time
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<HotDealItem>() {
            override fun areItemsTheSame(oldItem: HotDealItem, newItem: HotDealItem): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: HotDealItem, newItem: HotDealItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}
