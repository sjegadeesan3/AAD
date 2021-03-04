package com.jegadeesan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.jegadeesan.adapter.MainTopicAdapter
import com.jegadeesan.data.MainTopic
import com.jegadeesan.data.MainTopicConstants
import com.jegadeesan.data.MainTopicConstants.ANDROID_CORE
import com.jegadeesan.data.MainTopicConstants.DATA_MANAGEMENT
import com.jegadeesan.data.MainTopicConstants.DEBUGGING
import com.jegadeesan.data.MainTopicConstants.TESTING
import com.jegadeesan.data.MainTopicConstants.USER_INTERFACE
import com.jegadeesan.databinding.FragmentMainTopicBinding
import com.jegadeesan.viewmodel.MainTopicViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainTopicFragment : Fragment(), MainTopicAdapter.MainTopicAdapterClickListener {

    private var binding: FragmentMainTopicBinding? = null

    private val mainTopicViewModel: MainTopicViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainTopicBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding?.mainTopicRecyclerView?.apply {
            binding?.mainTopicRecyclerView?.layoutManager = LinearLayoutManager(activity)
            adapter = MainTopicAdapter(this@MainTopicFragment, mainTopicViewModel.getMainTopics())
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
                Toast.makeText(activity, mainTopic.uniqueId, Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(activity, "Error!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}