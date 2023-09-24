package com.app.sampleitktwo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: WisataApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://dev.farizdotid.com/api/purwakarta/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WisataApi::class.java)
    }
}