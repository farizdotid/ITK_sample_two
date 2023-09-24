package com.app.sampleitktwo.model.response


import com.google.gson.annotations.SerializedName

data class RespWisata(
    @SerializedName("wisata")
    val wisata: List<Wisata>
) {
    data class Wisata(
        @SerializedName("gambar_url")
        val gambarUrl: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("kategori")
        val kategori: String?,
        @SerializedName("nama")
        val nama: String?
    )
}