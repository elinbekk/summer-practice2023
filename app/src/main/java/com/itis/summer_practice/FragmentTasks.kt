package com.itis.practice

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
//import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.itis.practice.databinding.FragmentTasksBinding

class FragmentTasks: Fragment(R.layout.fragment_tasks) {
    private var binding: FragmentTasksBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTasksBinding.bind(view)
        val className = this.javaClass.simpleName
        binding?.btnToTracker?.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("ARG_NAME", className)
            findNavController().navigate(R.id.fragmentTracker)
            Snackbar.make(binding!!.root, className, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}