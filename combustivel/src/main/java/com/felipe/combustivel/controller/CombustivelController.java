package com.felipe.combustivel.controller;

import com.felipe.combustivel.dto.request.CombustivelRequestDTO;
import com.felipe.combustivel.dto.response.CombustivelResponseDTO;
import com.felipe.combustivel.service.CombustivelService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/combustivel")
public class CombustivelController {
    private final CombustivelService combustivelService;

    public CombustivelController(CombustivelService combustivelService) {
        this.combustivelService = combustivelService;
    }

    //POST
    @PostMapping
    public ResponseEntity<CombustivelResponseDTO> calcular(@RequestBody @Valid CombustivelRequestDTO dto) {
        CombustivelResponseDTO response = combustivelService.calcular(dto);
        return ResponseEntity.ok(response);
    }
}
