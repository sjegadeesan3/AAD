package com.jegadeesan.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jegadeesan.databinding.ActivityMainBinding
import com.jegadeesan.ui.fragments.MainTopicFragment
import com.jegadeesan.ui.fragments.SubTopicFragment

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
        setSupportActionBar(binding.toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.title = "AAD Project"
        binding.toolbar.title = "AAD Project"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }

    override fun mainTopicFragmentInitSuccessCallBack() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.title = "Main Topic"
    }

    override fun subTopicFragmentInitSuccessCallBack() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Sub Topic"
    }
}