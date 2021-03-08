package com.jegadeesan.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.jegadeesan.R
import com.jegadeesan.databinding.ActivitySnackBarBinding
import org.koin.android.ext.android.bind

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
        initButtons()
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


    private fun initButtons() {
        binding.showSnackBar.setOnClickListener {
            Snackbar.make(binding.root, getString(R.string.snackbar_text), Snackbar.LENGTH_SHORT).show()
        }
        binding.showSnackbarCenter.setOnClickListener {
            Snackbar.make(binding.snackbarCoordinatorLayout, getString(R.string.snackbar_text), Snackbar.LENGTH_SHORT).show()
        }
        binding.showSnackbarWithAction.setOnClickListener {
            val snackbar = Snackbar.make(binding.root, getString(R.string.snackbar_text), Snackbar.LENGTH_SHORT)
            snackbar.setAction(R.string.close) {
                snackbar.dismiss()
            }
            snackbar.show()

        }
    }

}