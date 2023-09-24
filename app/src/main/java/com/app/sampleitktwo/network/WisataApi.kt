package com.app.sampleitktwo.network

import com.app.sampleitktwo.model.response.RespWisata
import retrofit2.Call
import retrofit2.http.GET

interface WisataApi {
    @GET("wisata")
    fun getWisata(): Call<RespWisata>
}