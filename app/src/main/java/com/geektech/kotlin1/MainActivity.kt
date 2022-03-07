package com.geektech.kotlin1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.*
import androidx.appcompat.app.AppCompatActivity
import com.geektech.kotlin1.Constants.KEY1
import com.geektech.kotlin1.Constants.KEY_BACK
import com.geektech.kotlin1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var registerForActivityResult: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.btnIntent.setOnClickListener {
            if (viewBinding.etText.text.toString().isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.warning),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Intent(this@MainActivity, MainActivity2::class.java).apply {
                    putExtra(KEY1, viewBinding.etText.text.toString())

                    registerForActivityResult.launch(this)
                }
            }
        }
        registerForActivityResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            viewBinding.etText.setText(it.data?.getStringExtra(KEY_BACK))
        }

    }
}
