package com.itis.practice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.itis.practice.databinding.FragmentSettingsBinding

class FragmentSettings:Fragment() {
    private var binding: FragmentSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}