package com.jegadeesan.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.jegadeesan.R
import com.jegadeesan.adapter.MainTopicAdapter
import com.jegadeesan.data.MainTopic
import com.jegadeesan.data.MainTopicConstants.ANDROID_CORE
import com.jegadeesan.data.MainTopicConstants.DATA_MANAGEMENT
import com.jegadeesan.data.MainTopicConstants.DEBUGGING
import com.jegadeesan.data.MainTopicConstants.TESTING
import com.jegadeesan.data.MainTopicConstants.USER_INTERFACE
import com.jegadeesan.databinding.FragmentMainTopicBinding
import com.jegadeesan.viewmodel.TopicViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainTopicFragment : Fragment(), MainTopicAdapter.MainTopicAdapterClickListener {

    private var binding: FragmentMainTopicBinding? = null

    private var mainTopicFragmentInterface: MainTopicFragmentInterface? = null
    private val topicViewModel: TopicViewModel by sharedViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainTopicBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainTopicFragmentInterface?.mainTopicFragmentInitSuccessCallBack()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding?.mainTopicRecyclerView?.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MainTopicAdapter(this@MainTopicFragment, topicViewModel.getMainTopics())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MainTopicFragmentInterface) {
            mainTopicFragmentInterface = context
        } else {
            throw ClassCastException(activity.toString()
                    + " must implement MainTopicFragmentInterface");
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onClick(mainTopic: MainTopic) {
        when(mainTopic.uniqueId) {
            ANDROID_CORE,
            USER_INTERFACE,
            DATA_MANAGEMENT,
            DEBUGGING,
            TESTING-> {
                mainTopicFragmentInterface?.onSelectMainTopic(mainTopic)
            }
            else -> {
                Toast.makeText(activity, getString(R.string.invalid_main_topic_selection), Toast.LENGTH_SHORT).show()
            }
        }
    }

    interface MainTopicFragmentInterface {
        fun mainTopicFragmentInitSuccessCallBack()
        fun onSelectMainTopic(mainTopic: MainTopic)
    }
}