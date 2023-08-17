package com.solutis.car.model.dto;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcessorioDTO {

    private Long id;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 3, max = 200, message = "A descrição deve ter entre 3 e 200 caracteres")
    private String descricao;

    @JsonIgnore
    private Collection<CarroDTO> carro;

}
