package com.example.a22byte.fragments

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.example.a22byte.Answer
import com.example.a22byte.databinding.QuestionFragmentBinding
import com.example.a22byte.viewModels.QuestionsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.random.Random


class QuestionFragment: Fragment() {
    private var _binding: QuestionFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<QuestionsViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = QuestionFragmentBinding.inflate(inflater, container, false)
        viewModel.getBooks()
        viewModel.books.observe(viewLifecycleOwner){
            if (count>=10){
                val ft: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
                ft.replace(com.example.a22byte.R.id.navHostFragment, newInstance(answers as ArrayList<Answer>, rightCount))
                ft.commit()
            }
            val s: MutableSet<Int> = mutableSetOf()
            while (s.size < 3) { s.add((0..9).random()) }
            val randomList = s.toList()
            val randomText = Random.nextInt(0,3)
            Glide.with(this).load(it[randomList[0]].imageSource).into(binding.firstAns)
            Glide.with(this).load(it[randomList[1]].imageSource).into(binding.secondAns)
            Glide.with(this).load(it[randomList[2]].imageSource).into(binding.thirdAns)
            binding.bookText.text = it[randomList[randomText]].bookFirstLine
            binding.firstAns.setOnClickListener {
                checkAndRestart(randomList, 0)
            }
            binding.secondAns.setOnClickListener {
                checkAndRestart(randomList, 1)
            }
            binding.thirdAns.setOnClickListener {
                checkAndRestart(randomList, 2)
            }
            Log.d("answers", rightCount.toString() )
            Log.e("answers", count.toString() )
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object{
        var count = 0
        var rightCount = 0
        val answers: MutableList<Answer> = mutableListOf()
            fun newInstance(myList : ArrayList<Answer>, rightAnswers: Int): ResultFragment {
                val args = Bundle()
                args.putParcelableArrayList("list",myList);
                args.putInt("rightAnswers", rightAnswers)
                val fragment = ResultFragment()
                fragment.arguments = args
                return fragment
            }
    }

    private fun checkAndRestart(randomList: List<Int>, index: Int): Answer{
        count++
        val answer = Answer(text = binding.bookText.text as String)
        if (viewModel.books.value!![randomList[index]].bookFirstLine==binding.bookText.text){
            rightCount++
            answer.state = "true"
        }
        answers.add(answer)
        viewModel.getBooks()
        return answer
    }
}