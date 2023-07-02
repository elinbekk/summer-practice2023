package com.itis.practice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.project.summer_practice.databinding.FragmentZodiacsBinding

class ListFragment: Fragment(R.layout.fragment_zodiacs) {
    private var binding: FragmentZodiacsBinding? = null
    private var adapter: ZodiacAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentZodiacsBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = ZodiacAdapter(
            list = ZodiacRepo.list,
            glide = Glide.with(this),
            onItemClick = { zodiac->
                findNavController().navigate(R.id.action_informationFragment_to_informationAboutCityFragment,
                    DetailFragment.createBundle(zodiac.id))
            }
        )
        binding?.rvZodiac?.adapter = adapter
        binding?.rvZodiac?.layoutManager = GridLayoutManager(requireContext(), 2)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}