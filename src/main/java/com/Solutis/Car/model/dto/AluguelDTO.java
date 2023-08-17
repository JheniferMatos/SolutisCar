package com.solutis.car.model.dto;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AluguelDTO {

    private Long id;

    @NotBlank(message = "A data do pedido é obrigatória")
    private Calendar dataPedido;

    @NotBlank(message = "A data de entrega é obrigatória")
    private Date dataEntrega;

    @NotBlank(message = "A data de devolução é obrigatória")
    private Date dataDevolucao;

    @NotBlank(message = "O valor total é obrigatório")
    private BigDecimal valorTotal;

    @JsonIgnoreProperties("aluguel")
    private CarroDTO carro;

    @JsonIgnoreProperties("aluguel")
    private MotoristaDTO motorista;

    @JsonIgnoreProperties("aluguel")
    private ApoliceSeguroDTO apoliceSeguro;

}
