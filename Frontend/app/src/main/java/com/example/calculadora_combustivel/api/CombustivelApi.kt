package com.example.calculadora_combustivel.api

import com.example.calculadora_combustivel.dto.request.CombustivelRequest
import com.example.calculadora_combustivel.dto.response.CombustivelResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface CombustivelApi {
    @POST("/combustivel")
    suspend fun calcular(@Body request: CombustivelRequest): CombustivelResponse
}