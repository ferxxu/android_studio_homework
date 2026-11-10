package com.example.firsttry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFirstExercise = findViewById<Button>(R.id.btnFirstExercise)
        val btnCalculadora = findViewById<Button>(R.id.btnCalculadora)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnSensors = findViewById<Button>(R.id.btnSensors)

        btnFirstExercise.setOnClickListener {
            startActivity(Intent(this, FirstExerciseActivity::class.java))
        }

        btnCalculadora.setOnClickListener {
            startActivity(Intent(this, CalculadoraActivity::class.java))
        }

        btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnSensors.setOnClickListener {
            startActivity(Intent(this, SensorsActivity::class.java))
        }
    }
}