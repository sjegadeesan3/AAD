package com.jegadeesan.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jegadeesan.R
import com.jegadeesan.adapter.SubTopicAdapter
import com.jegadeesan.data.MainTopic
import com.jegadeesan.data.SubTopic
import com.jegadeesan.databinding.FragmentSubTopicBinding
import com.jegadeesan.viewmodel.TopicViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SubTopicFragment : Fragment(), SubTopicAdapter.SubTopicAdapterClickListener {

    private var mainTopic: MainTopic? = null
    private var subTopicFragmentInterface: SubTopicFragmentInterface? = null
    private var binding: FragmentSubTopicBinding? = null
    private val topicViewModel: TopicViewModel by sharedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initArguments()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        subTopicFragmentInterface = context as? SubTopicFragmentInterface
        if(subTopicFragmentInterface == null) {
            throw ClassCastException(activity.toString()
                    + " must implement MainTopicFragmentInterface");
        }
    }

    private fun initArguments() {
        arguments?.let { bundle ->
            mainTopic = bundle.getSerializable(MAIN_TOPIC)?.let { it as MainTopic }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubTopicBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subTopicFragmentInterface?.subTopicFragmentInitSuccessCallBack(mainTopic?.mainTopicName ?: getString(R.string.sub_topic_toolbar_header))
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding?.subTopicRecyclerView?.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = SubTopicAdapter(this@SubTopicFragment, topicViewModel.getSubTopics(mainTopic?.uniqueId))
        }
    }

    interface SubTopicFragmentInterface {
        fun subTopicFragmentInitSuccessCallBack(toolbarHeader: String)
        fun onSelectSubTopic(subTopic: SubTopic)
    }

    companion object {
        const val MAIN_TOPIC = "mainTopic"
    }

    override fun onClick(subTopic: SubTopic) {
        subTopicFragmentInterface?.onSelectSubTopic(subTopic)
    }
}