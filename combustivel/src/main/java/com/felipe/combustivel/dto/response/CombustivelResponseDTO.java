package com.felipe.combustivel.dto.response;

import java.math.BigDecimal;

public class CombustivelResponseDTO {

    private String melhorCombustivel;
    private BigDecimal proporcao;

    public CombustivelResponseDTO(String melhorCombustivel, BigDecimal proporcao) {
        this.melhorCombustivel = melhorCombustivel;
        this.proporcao = proporcao;
    }

    public String getMelhorCombustivel() {
        return melhorCombustivel;
    }

    public BigDecimal getProporcao() {
        return proporcao;
    }
}
