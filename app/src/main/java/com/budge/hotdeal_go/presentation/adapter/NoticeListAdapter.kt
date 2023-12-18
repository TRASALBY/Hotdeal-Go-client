package com.budge.hotdeal_go.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.budge.hotdeal_go.data.model.NoticeItem
import com.budge.hotdeal_go.databinding.ItemNoticeBinding
import java.text.SimpleDateFormat
import java.util.Locale

class NoticeListAdapter(
    private val itemClick: (NoticeItem) -> (Unit)
) : ListAdapter<NoticeItem, NoticeListAdapter.NoticeViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val binding = ItemNoticeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoticeViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class NoticeViewHolder(
        private val binding: ItemNoticeBinding,
        private val itemClick: (NoticeItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        lateinit var noticeItem: NoticeItem

        init {
            itemView.setOnClickListener { itemClick(noticeItem) }
        }

        fun bind(noticeItem: NoticeItem) {
            this.noticeItem = noticeItem
            val simpleDateParser = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREAN)
            val simpleDateFormatter = SimpleDateFormat("MM-dd HH:mm")
            binding.noticeTitleTV.text = noticeItem.title
            binding.noticeContentTV.text = noticeItem.content
            binding.noticeTimeTV.text =
                simpleDateFormatter.format(simpleDateParser.parse(noticeItem.registerTime))
                    ?: "정보없음"
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<NoticeItem>() {
            override fun areItemsTheSame(oldItem: NoticeItem, newItem: NoticeItem): Boolean {
                return oldItem.no == newItem.no
            }

            override fun areContentsTheSame(oldItem: NoticeItem, newItem: NoticeItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}
