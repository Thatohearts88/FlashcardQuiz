package com.example.flashcardquiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class QuizActivity : AppCompatActivity() {

    private val questions = listOf(
        Pair("The earth is flat.", false),
        Pair("There are 365 days in a year.", true),
        Pair("The sun rises in the west.", false),
        Pair("Water freezes at 0°C.", true),
        Pair("Python is a type of snake and programming language.", true)
    )

    private var currentIndex = 0
    private var score = 0

    private lateinit var tvQuestion: TextView
    private lateinit var tvFeedback: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityquiz)

        tvQuestion = findViewById(R.id.tvQuestion)
        tvFeedback = findViewById(R.id.tvFeedback)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)

        showQuestion()

        btnTrue.setOnClickListener {
            checkAnswer(true)
        }

        btnFalse.setOnClickListener {
            checkAnswer(false)
        }
    }

    private fun showQuestion() {
        if (currentIndex < questions.size) {
            tvQuestion.text = questions[currentIndex].first
            tvFeedback.text = ""
        } else {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("score", score)
            intent.putExtra("total", questions.size)
            startActivity(intent)
            finish()
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questions[currentIndex].second
        if (userAnswer == correctAnswer) {
            score++
            tvFeedback.text = "Correct!"
        } else {
            tvFeedback.text = "Incorrect."
        }

        currentIndex++
        tvQuestion.postDelayed({ showQuestion() }, 1000)
    }
}
