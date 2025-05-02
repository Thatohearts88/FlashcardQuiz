package com.example.flashcardquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

   
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        val tvScore: TextView = findViewById(R.id.tvScore)
        val btnTryAgain: Button = findViewById(R.id.btnTryAgain)
        val btnExit: Button = findViewById(R.id.btnExit)

        tvScore.text = "You scored $score out of $total"

        btnTryAgain.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnExit.setOnClickListener {
            finishAffinity() // Closes all activities and exits app
        }
    }
}
