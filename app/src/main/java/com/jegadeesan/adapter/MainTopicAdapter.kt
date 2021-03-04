package com.jegadeesan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jegadeesan.data.MainTopic
import com.jegadeesan.databinding.TopicItemRowBinding

class MainTopicAdapter(private val clickListener: MainTopicAdapterClickListener, private val mainTopicList: List<MainTopic>) :
    RecyclerView.Adapter<MainTopicAdapter.MainTopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainTopicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopicItemRowBinding.inflate(inflater, parent, false)
        return MainTopicViewHolder(binding)
    }

    override fun getItemCount(): Int =
        mainTopicList.size

    override fun onBindViewHolder(holder: MainTopicViewHolder, position: Int) {
        val mainTopic = mainTopicList[position]
        holder.bind(mainTopic)
        initClickListener(holder, mainTopic)
    }

    private fun initClickListener(holder: MainTopicViewHolder, mainTopic: MainTopic) {
        holder.mainTopicItemRowBinding.topicRowCardView.setOnClickListener {
            clickListener.onClick(mainTopic)
        }
    }

    class MainTopicViewHolder(val mainTopicItemRowBinding: TopicItemRowBinding) :
        RecyclerView.ViewHolder(mainTopicItemRowBinding.root) {

        fun bind(mainTopic: MainTopic) {
            mainTopicItemRowBinding.topicName.text = mainTopic.mainTopicName
        }
    }

    interface MainTopicAdapterClickListener {
        fun onClick(mainTopic: MainTopic)
    }
}