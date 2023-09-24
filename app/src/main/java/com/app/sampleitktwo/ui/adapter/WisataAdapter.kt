package com.app.sampleitktwo.ui.adapter;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.sampleitktwo.databinding.ItemWisataBinding
import com.app.sampleitktwo.model.response.RespWisata
import com.bumptech.glide.Glide

class WisataAdapter(private val list: List<RespWisata.Wisata>) :
    RecyclerView.Adapter<WisataAdapter.WisataAdapterHolder>() {

    private var onItemClickCallback: WisataAdapterCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataAdapterHolder {
        val binding = ItemWisataBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return WisataAdapterHolder(binding)
    }

    override fun onBindViewHolder(holder: WisataAdapterHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setOnItemClickCallback(adapterCallback: WisataAdapterCallback) {
        this.onItemClickCallback = adapterCallback
    }

    inner class WisataAdapterHolder(val binding: ItemWisataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: RespWisata.Wisata) {
            loadImage(item.gambarUrl.orEmpty())
            binding.tvName.text = item.nama.orEmpty()

            /**
             * Fungsi untuk memberikan action ketika user klik salah satu list dan juga
             * membawa data listnya
             */
            binding.root.setOnClickListener {
                onItemClickCallback?.onWisataAdapterClicked(item)
            }
        }

        /**
         * Fungsi untuk load image dari sebuah URL menggunakan library Glide
         */
        private fun loadImage(sourceUrl: String) {
            Glide.with(binding.ivImage.context)
                .load(sourceUrl)
                .centerCrop()
                .into(binding.ivImage)
        }
    }

    interface WisataAdapterCallback {
        fun onWisataAdapterClicked(wisata: RespWisata.Wisata)
    }
}