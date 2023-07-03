package com.itis.summerpractice2


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.itis.summerpractice2.databinding.FragmentZodiacBinding


class ZodiacFragment: Fragment(R.layout.fragment_zodiac) {
    private var binding: FragmentZodiacBinding? = null
    private var adapter: ZodiacAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentZodiacBinding.bind(view)
        initAdapter()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter(){
        adapter = ZodiacAdapter(
            list = ZodiacRepo.list,
            glide = Glide.with(this),
            onItemClick = {zodiac -> findNavController().navigate(R.id.action_zodiacFragment_to_detailFragment, DetailFragment.createBundle(zodiac.id))
            }
        )
        binding?.rvZodiac?.adapter = adapter
    }

}