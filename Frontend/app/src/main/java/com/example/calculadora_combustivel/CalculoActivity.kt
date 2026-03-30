package com.example.calculadora_combustivel

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo)

        val gasolina = findViewById<EditText>(R.id.etGasolina)
        val etanol = findViewById<EditText>(R.id.etEtanol)
        val btn = findViewById<Button>(R.id.btnCalcular)
        val resultado = findViewById<TextView>(R.id.tvResultado)

        btn.setOnClickListener {
            val g = gasolina.text.toString().toDoubleOrNull()
            val e = etanol.text.toString().toDoubleOrNull()

            if (g != null && e != null) {
                val proporcao = e / g

                val melhor = if (proporcao <= 0.7) "ETANOL" else "GASOLINA"

                resultado.text = "Melhor: $melhor"
            } else {
                resultado.text = "Preencha os valores corretamente"
            }
        }
    }
}