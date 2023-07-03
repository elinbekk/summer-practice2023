package com.itis.summerpractice2

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.itis.summerpractice2.databinding.ItemZodiacBinding


class ZodiacItem(
    private val binding: ItemZodiacBinding,
    private val glide: RequestManager,
    private val onItemClick: (Zodiac) -> Unit) :
    ViewHolder(binding.root) {

    private val options:RequestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE)

    fun onBind(zodiac: Zodiac) {
        binding.run {
            tvZodiac.text = zodiac.name
            tvDesc.text = zodiac.desc

            glide.load(zodiac.url)
                .apply(options)
                .into(ivImage)

            root.setOnClickListener{
                onItemClick(zodiac)
            }
        }
    }
}