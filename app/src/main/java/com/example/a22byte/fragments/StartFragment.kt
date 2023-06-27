package com.example.a22byte.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.a22byte.databinding.StartFragmentBinding

class StartFragment: Fragment() {
    private var _binding: StartFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = StartFragmentBinding.inflate(inflater, container, false)
        binding.playButton.setOnClickListener {
            val action = StartFragmentDirections.actionStartFragmentToQuestionFragment()
            it.findNavController().navigate(action)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}