package com.itis.practice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.project.summer_practice.databinding.FragmentZodiacsBinding
import com.itis.summer_practice.utils.showSnackbar

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var binding: FragmentZodiacsBinding? = null
    private var adapter:ZodiacAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentZodiacsBinding.bind(view)

    }
    private fun initAdapter() {
        adapter = ZodiacAdapter(
            list = ZodiacRepo.list,
            glide = Glide.with(this),
            onItemClick = { zodiac ->
                binding?.root?.showSnackbar(zodiac.name)
            }
        )
        binding?.rvZodiac?.adapter = adapter
    }

}