package com.solutis.car.model.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApoliceSeguroDTO {

    private Long id;

    @NotNull(message = "O valor da franquia é obrigatório")
    private BigDecimal valorFranquia;

    private boolean protecaoTerceiro = false;

    private boolean protecaoCausasNaturais = false;

    private boolean protecaoRoubo = false;

}
