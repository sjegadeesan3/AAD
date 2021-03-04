package com.jegadeesan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jegadeesan.data.SubTopic
import com.jegadeesan.databinding.TopicItemRowBinding

class SubTopicAdapter(private val clickListener: SubTopicAdapterClickListener, private val subTopicList: List<SubTopic>) :
    RecyclerView.Adapter<SubTopicAdapter.SubTopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubTopicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopicItemRowBinding.inflate(inflater, parent, false)
        return SubTopicViewHolder(binding)
    }

    override fun getItemCount(): Int =
        subTopicList.size

    override fun onBindViewHolder(holder: SubTopicViewHolder, position: Int) {
        val subTopic = subTopicList[position]
        holder.bind(subTopic)
        initClickListener(holder, subTopic)
    }

    private fun initClickListener(holder: SubTopicViewHolder, subTopic: SubTopic) {
        holder.topicItemRowBinding.topicRowCardView.setOnClickListener {
            clickListener.onClick(subTopic)
        }
    }

    class SubTopicViewHolder(val topicItemRowBinding: TopicItemRowBinding) :
        RecyclerView.ViewHolder(topicItemRowBinding.root) {

        fun bind(subTopic: SubTopic) {
            topicItemRowBinding.topicName.text = subTopic.subTopicName
        }
    }

    interface SubTopicAdapterClickListener {
        fun onClick(subTopic: SubTopic)
    }
}