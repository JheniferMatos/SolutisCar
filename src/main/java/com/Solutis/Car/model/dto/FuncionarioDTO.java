package com.solutis.car.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FuncionarioDTO extends PessoaDTO {

    @NotBlank(message = "A matrícula é obrigatória")
    @Size(min = 3, max = 20, message = "A matrícula deve ter entre 3 e 20 caracteres")
    private String matricula;

}
