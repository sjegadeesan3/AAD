package com.jegadeesan.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jegadeesan.R
import com.jegadeesan.data.MainTopic
import com.jegadeesan.databinding.FragmentSubTopicBinding

class SubTopicFragment : Fragment() {

    private var mainTopic: MainTopic? = null
    private var subTopicFragmentInterface: SubTopicFragmentInterface? = null
    lateinit var binding: FragmentSubTopicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initArguments()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        subTopicFragmentInterface = context as? SubTopicFragmentInterface
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subTopicFragmentInterface?.subTopicFragmentInitSuccessCallBack(mainTopic?.mainTopicName ?: getString(R.string.sub_topic_toolbar_header))
        binding.info.text = mainTopic?.mainTopicName
    }


    interface SubTopicFragmentInterface {
        fun subTopicFragmentInitSuccessCallBack(toolbarHeader: String)
    }

    companion object {
        const val MAIN_TOPIC = "mainTopic"
    }
}