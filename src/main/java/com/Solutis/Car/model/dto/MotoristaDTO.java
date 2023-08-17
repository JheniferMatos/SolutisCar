package com.solutis.car.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MotoristaDTO extends PessoaDTO {

    @NotBlank(message = "O número da CNH é obrigatório")
    @Size(min = 11, max = 11, message = "O número da CNH deve ter 11 digitos")
    @Pattern(regexp = "\\d{11}", message = "Número da CNH inválido")
    private String numeroCNH;

    @JsonIgnoreProperties({"motorista"})
    private Collection<AluguelDTO> aluguel;

}
