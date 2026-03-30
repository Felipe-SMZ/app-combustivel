package com.example.calculadora_combustivel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculadora_combustivel.dto.request.CombustivelRequest
import com.example.calculadora_combustivel.dto.response.CombustivelResponse
import com.example.calculadora_combustivel.network.RetrofitClient
import kotlinx.coroutines.launch

class CalculoViewModel : ViewModel() {

    // Estados que a Activity vai observar
    val resultado = MutableLiveData<CombustivelResponse>()
    val erro = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()

    fun calcular(etanol: Double, gasolina: Double) {

        loading.value = true

        viewModelScope.launch {           // Coroutine — substitui o enqueue()
            try {
                val response = RetrofitClient.api.calcular(
                    CombustivelRequest(
                        valorEtanol = etanol,
                        valorGasolina = gasolina
                    )
                )
                resultado.value = response

            } catch (e: Exception) {
                erro.value = "Erro de conexão: ${e.message}"

            } finally {
                loading.value = false     // sempre desativa o loading no fim
            }
        }
    }
}