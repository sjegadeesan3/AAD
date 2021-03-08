package com.jegadeesan.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jegadeesan.R
import com.jegadeesan.databinding.ActivitySnackBarBinding

class SnackBarActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySnackBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySnackBarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        initToolbar()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.title_snackbar)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}