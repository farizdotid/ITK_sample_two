package com.app.sampleitktwo.ui.wisata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.sampleitktwo.model.response.RespWisata
import com.app.sampleitktwo.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WisataViewModel : ViewModel() {
    private var respWisata = MutableLiveData<RespWisata>()

    /**
     * Fungsi untuk memanggil API wisata
     */
    fun getWisata() {
        RetrofitInstance.api.getWisata().enqueue(object : Callback<RespWisata> {
            override fun onResponse(call: Call<RespWisata>, response: Response<RespWisata>) {
                if (response.body() != null) {
                    respWisata.value = response.body()
                }
            }

            override fun onFailure(call: Call<RespWisata>, t: Throwable) {
                /**
                 * Fungsi untuk Log jika case terdapat error pada hit API
                 */
                Log.e("DEBUG", "onFailure: Error ${t.message}")
            }

        })
    }

    /**
     * Fungsi untuk meng-observe atau return data dari hasil hit API Wisata
     */
    fun observeWisataLiveData(): LiveData<RespWisata> {
        return respWisata
    }
}