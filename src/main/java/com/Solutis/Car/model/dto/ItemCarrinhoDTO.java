package com.solutis.car.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarrinhoDTO {

    private Long id;

    private Long carroId;

    private LocalDate dataInicial;

    private LocalDate dataFinal;

    private BigDecimal preco;
}