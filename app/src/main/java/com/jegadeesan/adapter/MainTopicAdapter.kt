package com.jegadeesan.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jegadeesan.data.MainTopic
import com.jegadeesan.databinding.MainTopicItemRowBinding

class MainTopicAdapter(private val mainTopicList: List<MainTopic>) :
    RecyclerView.Adapter<MainTopicAdapter.MainTopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainTopicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MainTopicItemRowBinding.inflate(inflater, parent, false)
        return MainTopicViewHolder(binding)
    }

    override fun getItemCount(): Int =
        mainTopicList.size

    override fun onBindViewHolder(holder: MainTopicViewHolder, position: Int) {
        val mainTopic = mainTopicList[position]
        holder.bind(mainTopic)
    }

    class MainTopicViewHolder(private val mainTopicItemRowBinding: MainTopicItemRowBinding) :
        RecyclerView.ViewHolder(mainTopicItemRowBinding.root), View.OnClickListener {

        private val TAG = MainTopicViewHolder::class.simpleName

        init {
            mainTopicItemRowBinding.mainTopicRowCardView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            Log.d(TAG, "View Clicked")
        }

        fun bind(mainTopic: MainTopic) {
            mainTopicItemRowBinding.mainTopicName.text = mainTopic.mainTopicName
        }
    }
}