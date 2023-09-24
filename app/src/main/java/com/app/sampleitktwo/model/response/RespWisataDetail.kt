package com.app.sampleitktwo.model.response


import com.google.gson.annotations.SerializedName

data class RespWisataDetail(
    @SerializedName("deskripsi")
    val deskripsi: String?,
    @SerializedName("gambar_url")
    val gambarUrl: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("kategori")
    val kategori: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longitude")
    val longitude: String?,
    @SerializedName("nama")
    val nama: String?,
    @SerializedName("photo_by")
    val photoBy: String?
)