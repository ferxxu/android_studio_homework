package com.example.firsttry

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FirstExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing)

        val etInput = findViewById<EditText>(R.id.etInput)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val tvOutput = findViewById<TextView>(R.id.tvOutput)

        btnEnviar.setOnClickListener {
            val inputText = etInput.text.toString()
            if (inputText.isNotEmpty()) {
                tvOutput.text = inputText
                tvOutput.visibility = View.VISIBLE
                etInput.text.clear()
            }
        }
    }
}