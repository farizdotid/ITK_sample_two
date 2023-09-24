package com.app.sampleitktwo.ui.wisata

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.sampleitktwo.databinding.ActivityWisataBinding
import com.app.sampleitktwo.model.response.RespWisata
import com.app.sampleitktwo.ui.adapter.WisataAdapter

class WisataActivity : AppCompatActivity(){

    private lateinit var binding: ActivityWisataBinding
    private lateinit var viewModel: WisataViewModel
    private lateinit var wisataAdapter: WisataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWisataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initObserve()
    }

    private fun initObserve() {
        /**
         * Inisialisasi viewmodel
         */
        viewModel = ViewModelProvider(this)[WisataViewModel::class.java]

        /**
         * Fungsi untuk memanggil function getWisata pada viewmodel
         */
        viewModel.getWisata()

        viewModel.observeWisataLiveData().observe(this, Observer { respWisata ->
            val wisataList = respWisata.wisata
            initWisataAdapter(wisataList)
        })

    }

    private fun initWisataAdapter(wisataList: List<RespWisata.Wisata>) {
        wisataAdapter = WisataAdapter(wisataList).apply {
            setOnItemClickCallback(object :WisataAdapter.WisataAdapterCallback{
                override fun onWisataAdapterClicked(wisata: RespWisata.Wisata) {
                    val name = wisata.nama.orEmpty()
                    showToast(name)
                }

            })
        }
        binding.rvWisata.apply {
            layoutManager = LinearLayoutManager(this@WisataActivity)
            adapter = wisataAdapter
        }
    }

    private fun showToast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, WisataActivity::class.java)
            context.startActivity(starter)
        }
    }
}