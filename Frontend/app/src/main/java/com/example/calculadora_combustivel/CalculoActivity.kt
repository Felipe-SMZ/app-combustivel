package com.example.calculadora_combustivel

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class CalculoActivity : AppCompatActivity() {

    private lateinit var etGasolina: TextInputEditText
    private lateinit var etEtanol: TextInputEditText
    private lateinit var btnCalcular: MaterialButton
    private lateinit var tvResultado: TextView

    // Instancia o ViewModel — sobrevive à rotação de tela
    private val viewModel: CalculoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo)

        etGasolina = findViewById(R.id.etGasolina)
        etEtanol = findViewById(R.id.etEtanol)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        // Observa o resultado — atualiza a UI quando o ViewModel responder
        viewModel.resultado.observe(this) { res ->
            val melhor = res.melhorCombustivel
            val proporcao = res.proporcao

            tvResultado.text = "Melhor: $melhor\nProporção: %.2f".format(proporcao)

            if (melhor == "ETANOL") {
                tvResultado.setTextColor(Color.parseColor("#16A34A")) // verde
            } else {
                tvResultado.setTextColor(Color.parseColor("#DC2626")) // vermelho
            }
        }

        // Observa erros
        viewModel.erro.observe(this) { mensagem ->
            tvResultado.text = mensagem
            tvResultado.setTextColor(Color.RED)
        }

        // Observa o loading — desabilita o botão durante a chamada
        viewModel.loading.observe(this) { carregando ->
            btnCalcular.isEnabled = !carregando
            if (carregando) {
                tvResultado.text = "Calculando..."
                tvResultado.setTextColor(Color.GRAY)
            }
        }

        btnCalcular.setOnClickListener {
            val gasolina = etGasolina.text.toString().toDoubleOrNull()
            val etanol = etEtanol.text.toString().toDoubleOrNull()

            if (gasolina == null || etanol == null) {
                tvResultado.text = "Preencha os valores corretamente"
                tvResultado.setTextColor(Color.RED)
                return@setOnClickListener
            }

            viewModel.calcular(etanol, gasolina) // só delega ao ViewModel
        }
    }
}