package com.jegadeesan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jegadeesan.adapter.MainTopicAdapter
import com.jegadeesan.data.MainTopic
import com.jegadeesan.databinding.FragmentMainTopicBinding

class MainTopicFragment : Fragment() {

    private var binding: FragmentMainTopicBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
            adapter = MainTopicAdapter(getMainTopics())
        }
    }

    private fun getMainTopics(): List<MainTopic> {
        //ToDo : Move to view model
        val list = arrayListOf<MainTopic>()
        list.add(MainTopic(1, "Android core"))
        list.add(MainTopic(2, "User interface"))
        list.add(MainTopic(3, "Data management"))
        list.add(MainTopic(4, "Debugging"))
        list.add(MainTopic(5, "Testing"))
        return list
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainTopicFragment()
    }
}