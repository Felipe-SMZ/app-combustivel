package com.example.calculadora_combustivel

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora_combustivel.dto.request.CombustivelRequest
import com.example.calculadora_combustivel.dto.response.CombustivelResponse
import com.example.calculadora_combustivel.network.RetrofitClient
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalculoActivity : AppCompatActivity() {

    private lateinit var etGasolina: TextInputEditText
    private lateinit var etEtanol: TextInputEditText
    private lateinit var btnCalcular: MaterialButton
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo)

        // 🔗 Bind dos componentes
        etGasolina = findViewById(R.id.etGasolina)
        etEtanol = findViewById(R.id.etEtanol)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        // 🎯 Clique do botão
        btnCalcular.setOnClickListener {
            calcularCombustivel()
        }
    }

    private fun calcularCombustivel() {

        val gasolina = etGasolina.text.toString().toDoubleOrNull()
        val etanol = etEtanol.text.toString().toDoubleOrNull()

        // ✅ Validação
        if (gasolina == null || etanol == null) {
            tvResultado.text = "Preencha os valores corretamente"
            tvResultado.setTextColor(Color.RED)
            return
        }

        // 🔄 Criar request
        val request = CombustivelRequest(
            valorEtanol = etanol,
            valorGasolina = gasolina
        )

        tvResultado.text = "Calculando..."
        tvResultado.setTextColor(Color.GRAY)

        // 🌐 Chamada da API
        RetrofitClient.api.calcular(request)
            .enqueue(object : Callback<CombustivelResponse> {

                override fun onResponse(
                    call: Call<CombustivelResponse>,
                    response: Response<CombustivelResponse>
                ) {
                    if (response.isSuccessful) {

                        val resultado = response.body()

                        if (resultado != null) {

                            val melhor = resultado.melhorCombustivel
                            val proporcao = resultado.proporcao

                            tvResultado.text =
                                "Melhor: $melhor\nProporção: %.2f".format(proporcao)

                            // 🎨 Cor dinâmica
                            if (melhor == "ETANOL") {
                                tvResultado.setTextColor(Color.parseColor("#16A34A")) // verde
                            } else {
                                tvResultado.setTextColor(Color.parseColor("#DC2626")) // vermelho
                            }

                        } else {
                            tvResultado.text = "Erro: resposta vazia"
                            tvResultado.setTextColor(Color.RED)
                        }

                    } else {
                        tvResultado.text = "Erro na API (${response.code()})"
                        tvResultado.setTextColor(Color.RED)
                    }
                }

                override fun onFailure(call: Call<CombustivelResponse>, t: Throwable) {
                    tvResultado.text = "Erro de conexão"
                    tvResultado.setTextColor(Color.RED)
                }
            })
    }
}