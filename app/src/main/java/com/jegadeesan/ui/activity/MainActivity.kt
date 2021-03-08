package com.jegadeesan.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import com.jegadeesan.R
import com.jegadeesan.data.MainTopic
import com.jegadeesan.data.SubTopic
import com.jegadeesan.data.SubTopicConstants.ANDROID_CORE_SNACK_BAR
import com.jegadeesan.data.SubTopicConstants.ANDROID_CORE_TOAST
import com.jegadeesan.databinding.ActivityMainBinding
import com.jegadeesan.ui.fragments.MainTopicFragment
import com.jegadeesan.ui.fragments.SubTopicFragment
import com.jegadeesan.ui.fragments.SubTopicFragment.Companion.MAIN_TOPIC

class MainActivity : AppCompatActivity(), MainTopicFragment.MainTopicFragmentInterface, SubTopicFragment.SubTopicFragmentInterface {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        initToolbar()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar.toolbar)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun mainTopicFragmentInitSuccessCallBack() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.title = getString(R.string.main_topic_toolbar_header)
    }

    override fun onSelectMainTopic(mainTopic: MainTopic) {
        val bundle = bundleOf(MAIN_TOPIC to mainTopic)
        findNavController(binding.navHostFragment).navigate(R.id.action_main_topic_fragment_to_sub_topic_fragment, bundle)
    }

    override fun subTopicFragmentInitSuccessCallBack(toolbarHeader: String) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = toolbarHeader
    }

    override fun onSelectSubTopic(subTopic: SubTopic) {
        when(subTopic.uniqueId) {
            ANDROID_CORE_TOAST -> {
                val intent = Intent(this, ToastActivity::class.java)
                startActivity(intent)
            }
            ANDROID_CORE_SNACK_BAR -> {
                val intent = Intent(this, SnackBarActivity::class.java)
                startActivity(intent)
            }
            else -> {

            }
        }
    }
}