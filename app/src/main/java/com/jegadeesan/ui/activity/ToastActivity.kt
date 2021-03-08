package com.jegadeesan.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jegadeesan.R
import com.jegadeesan.databinding.ActivityToastBinding

class ToastActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToastBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        initToolbar()
        initButtons()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.title_toast)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initButtons() {
        binding.shortToast.setOnClickListener {
            Toast.makeText(this, getString(R.string.short_toast_message), Toast.LENGTH_SHORT).show()
        }
        binding.longToast.setOnClickListener {
            Toast.makeText(this, getString(R.string.long_toast_message), Toast.LENGTH_LONG).show()
        }
    }
}