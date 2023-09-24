package com.app.sampleitktwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.sampleitktwo.databinding.ActivityMainBinding
import com.app.sampleitktwo.ui.wisata.WisataActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initAction()
    }

    private fun initAction(){
        binding.btnWisata.setOnClickListener {
            WisataActivity.start(this)
        }
    }
}