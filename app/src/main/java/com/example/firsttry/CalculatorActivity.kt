package com.example.firsttry

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculadoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

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
}