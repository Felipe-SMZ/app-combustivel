package com.felipe.combustivel.service;

import com.felipe.combustivel.dto.request.CombustivelRequestDTO;
import com.felipe.combustivel.dto.response.CombustivelResponseDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CombustivelService {
    //define a constante
    private static final BigDecimal LIMITE = new BigDecimal("0.7");


    public CombustivelResponseDTO calcular(CombustivelRequestDTO dto) {
        // Divide o valor do álcool pela gasolina com 4 casas decimais e arredondamento padrão
        BigDecimal proporcao = dto.getValorEtanol()
                .divide(dto.getValorGasolina(), 4, RoundingMode.HALF_UP);


        String melhorCombustivel = (proporcao.compareTo(LIMITE) <= 0)
                ? "ETANOL"
                : "GASOLINA";

        return new CombustivelResponseDTO(melhorCombustivel, proporcao);
    }
}
