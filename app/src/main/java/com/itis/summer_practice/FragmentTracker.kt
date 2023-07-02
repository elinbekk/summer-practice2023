package com.itis.practice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.itis.practice.databinding.FragmentTrackerBinding

class FragmentTracker: Fragment(R.layout.fragment_tracker) {
    private var binding: FragmentTrackerBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTrackerBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}