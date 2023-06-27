package com.example.a22byte.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a22byte.Answer
import com.example.a22byte.adapters.AnswerAdapter
import com.example.a22byte.databinding.ResultFragmentBinding

class ResultFragment: Fragment() {
    private var _binding: ResultFragmentBinding? = null
    private val binding get() = _binding!!
    private val adapter = AnswerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ResultFragmentBinding.inflate(inflater, container, false)
        val args = arguments
        val myList : ArrayList<Answer> = args?.getParcelableArrayList<Answer>("list")!!
        adapter.set(myList)
        binding.answersRv.adapter = adapter
        binding.answersCount.text = args.getInt("rightAnswers").toString()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}