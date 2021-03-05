package com.jegadeesan.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jegadeesan.R
import com.jegadeesan.data.MainTopic
import com.jegadeesan.databinding.FragmentSubTopicBinding
import java.lang.Exception

class SubTopicFragment : Fragment() {

    private var mainTopic: MainTopic? = null
    lateinit var binding: FragmentSubTopicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            try {
                mainTopic = it.getSerializable(MAIN_TOPIC) as MainTopic
            } catch (e: Exception) { }
        }
        mainTopic?.mainTopicName

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubTopicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity is SubTopicFragmentInterface) {
            (activity as SubTopicFragmentInterface).apply {
                subTopicFragmentInitSuccessCallBack(mainTopic?.mainTopicName ?: getString(R.string.sub_topic_toolbar_header))
            }
        }
        binding.info.text = mainTopic?.mainTopicName
    }


    interface SubTopicFragmentInterface {
        fun subTopicFragmentInitSuccessCallBack(toolbarHeader: String)
    }

    companion object {
        const val MAIN_TOPIC = "mainTopic"
    }
}