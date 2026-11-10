package com.example.firsttry

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvSuccessMessage = findViewById<TextView>(R.id.tvSuccessMessage)

        val credentials = mapOf(
            "email" to "example@gmail.com",
            "password" to "123"
        )

        fun checkAddress(emailAddress: String?): Boolean {
            val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
            if (emailAddress.isNullOrEmpty()) return false
            return emailRegex.toRegex().matches(emailAddress)
        }

        btnLogin.setOnClickListener {
            val inputEmail = etEmail.text.toString()
            val inputPass = etPassword.text.toString()

            val errorMessage: String? = when {
                !checkAddress(inputEmail) -> "Formato de correo inválido"
                inputEmail != credentials["email"] -> "El correo no está registrado"
                inputPass != credentials["password"] -> "Contraseña inválida"
                else -> null
            }

            if (errorMessage == null) {
                tvSuccessMessage.text = "Has iniciado sesión exitosamente"
                tvSuccessMessage.visibility = View.VISIBLE
            } else {
                tvSuccessMessage.visibility = View.GONE
                val intent = Intent(this, ErrorActivity::class.java).apply {
                    putExtra("EXTRA_ERROR_MESSAGE", errorMessage)
                }
                startActivity(intent)
            }
        }
    }
}