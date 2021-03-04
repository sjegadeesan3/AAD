package com.jegadeesan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jegadeesan.adapter.MainTopicAdapter
import com.jegadeesan.databinding.FragmentMainTopicBinding
import com.jegadeesan.viewmodel.MainTopicViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainTopicFragment : Fragment() {

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
            adapter = MainTopicAdapter(mainTopicViewModel.getMainTopics())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}