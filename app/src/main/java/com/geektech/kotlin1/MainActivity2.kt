package com.geektech.kotlin1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geektech.kotlin1.Constants.KEY1
import com.geektech.kotlin1.Constants.KEY_BACK
import com.geektech.kotlin1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMain2Binding.inflate(layoutInflater)
         setContentView(viewBinding.root)
        viewBinding.etValue.setText(intent.getStringExtra(KEY1))
        viewBinding.btnBack.setOnClickListener {
            setResult(RESULT_OK, Intent().putExtra(KEY_BACK, viewBinding.etValue.text.toString()))
            finish()
        }
    }
}