package com.itis.practice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.itis.practice.databinding.FragmentHomeBinding

class FragmentHome:Fragment(R.layout.fragment_home) {
    private var binding: FragmentHomeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding?.btnToProfile?.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentHome_to_fragmentProfile)
        }
        binding?.btnToTasks?.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentHome_to_fragmentTasks)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}