package com.example.firsttry

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Carga el layout que quieras probar (ej: Login)
        setContentView(R.layout.login)

        // Descomenta el metodo según la pantalla que quieras activar:
        // setupFirstExercise()
        // setupCalculadora()
        setupLogin()
    }

    private fun setupFirstExercise() {
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

    private fun setupCalculadora() {
        val etNum1 = findViewById<EditText>(R.id.etNum1)
        val etNum2 = findViewById<EditText>(R.id.etNum2)
        val btnSum = findViewById<Button>(R.id.btnSum)
        val btnRes = findViewById<Button>(R.id.btnRes)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        val sum = { a: Double, b: Double -> a + b }
        val res = { a: Double, b: Double -> a - b }
        val div = { a: Double, b: Double -> if (b != 0.0) a / b else Double.NaN }
        val mul = { a: Double, b: Double -> a * b }

        fun calcular(operacion: (Double, Double) -> Double) {
            val a = etNum1.text.toString().toDoubleOrNull() ?: 0.0
            val b = etNum2.text.toString().toDoubleOrNull() ?: 0.0
            val result = operacion(a, b)

            tvResultado.text = "Resultado: $result"
            tvResultado.visibility = View.VISIBLE
        }

        btnSum.setOnClickListener { calcular(sum) }
        btnRes.setOnClickListener { calcular(res) }
        btnMul.setOnClickListener { calcular(mul) }
        btnDiv.setOnClickListener { calcular(div) }
    }

    private fun setupLogin() {
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)

        val credentials: Map<String, String> = mapOf(
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
            val message: String

            if (checkAddress(inputEmail)) {
                if (inputEmail == credentials["email"]) {
                    if (inputPass == credentials["password"]) {
                        message = "Has iniciado sesión exitosamente"
                    } else {
                        message = "Contraseña inválida"
                    }
                } else {
                    message = "El correo no está registrado"
                }
            } else {
                message = "Usted ha ingresado un formato de correo inválido"
            }

            tvMessage.text = message
            tvMessage.visibility = View.VISIBLE
        }
    }
}