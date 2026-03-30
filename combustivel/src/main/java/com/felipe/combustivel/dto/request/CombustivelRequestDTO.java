package com.felipe.combustivel.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CombustivelRequestDTO {

    @NotNull(message = "O valor do etanol é obrigatório!")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero")
    @Digits(integer = 12, fraction = 2, message = "O valor deve ter no máximo 12 dígitos inteiros e 2 casas decimais")
    private BigDecimal valorEtanol;

    @NotNull(message = "O valor da gasolina é obrigatório!")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero")
    @Digits(integer = 12, fraction = 2, message = "O valor deve ter no máximo 12 dígitos inteiros e 2 casas decimais")
    private BigDecimal valorGasolina;


    public CombustivelRequestDTO() {
    }

    public CombustivelRequestDTO(BigDecimal valorEtanol, BigDecimal valorGasolina) {
        this.valorEtanol = valorEtanol;
        this.valorGasolina = valorGasolina;
    }

    public BigDecimal getValorEtanol() {
        return valorEtanol;
    }

    public BigDecimal getValorGasolina() {
        return valorGasolina;
    }

    public void setValorEtanol(BigDecimal valorEtanol) {
        this.valorEtanol = valorEtanol;
    }

    public void setValorGasolina(BigDecimal valorGasolina) {
        this.valorGasolina = valorGasolina;
    }
}
