package com.itis.practice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.project.summer_practice.databinding.ItemZodiacBinding

class ZodiacAdapter(private var list: List<Zodiac>,
                    private val glide: RequestManager,
                    private val onItemClick: (Zodiac) -> Unit,
) : RecyclerView.Adapter<ZodiacItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ZodiacItem {
        return ZodiacItem(
            binding = ItemZodiacBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            onItemClick = onItemClick
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ZodiacItem, position: Int) {
        holder.onBind(list[position])
    }
}
