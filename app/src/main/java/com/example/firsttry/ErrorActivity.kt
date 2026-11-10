package com.example.firsttry

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ErrorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        val tvErrorMessage = findViewById<TextView>(R.id.tvErrorMessage)
        val ivRetry = findViewById<ImageView>(R.id.ivRetry)

        val message = intent.getStringExtra("EXTRA_ERROR_MESSAGE") ?: "Error al iniciar sesión"
        tvErrorMessage.text = message

        ivRetry.setOnClickListener {
            finish()
        }
    }
}