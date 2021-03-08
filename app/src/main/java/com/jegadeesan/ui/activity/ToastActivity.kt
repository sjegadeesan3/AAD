package com.jegadeesan.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.jegadeesan.R
import com.jegadeesan.databinding.ActivityToastBinding
import com.jegadeesan.databinding.CustomToastLayoutBinding

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

        binding.customToast.setOnClickListener {
            val customToastLayoutBinding = CustomToastLayoutBinding.inflate(layoutInflater)
            customToastLayoutBinding.toastText.text = getString(R.string.custom_toast)
            with(Toast(applicationContext)) {
                setGravity(Gravity.CENTER_VERTICAL, 0, 0)
                duration = Toast.LENGTH_SHORT
                view =customToastLayoutBinding.root
                show()
            }
        }
    }
}