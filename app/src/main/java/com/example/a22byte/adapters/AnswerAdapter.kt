package com.example.a22byte.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a22byte.Answer
import com.example.a22byte.databinding.AnswerItemBinding

class AnswerAdapter: RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder>() {
    var answers: List<Answer> = listOf()

    class AnswerViewHolder(binding: AnswerItemBinding): RecyclerView.ViewHolder(binding.root){
        val answerText = binding.answer
        val answerStatus = binding.answerStatus
        fun bind(answer: Answer){
            answerText.text = answer.text
            if (answer.state=="true"){
                answerStatus.isChecked = true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        val view = AnswerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnswerViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        holder.bind(answers[position])
    }

    override fun getItemCount(): Int {
        return answers.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun set(answers: List<Answer>){
        this.answers = answers
        notifyDataSetChanged()
    }
}