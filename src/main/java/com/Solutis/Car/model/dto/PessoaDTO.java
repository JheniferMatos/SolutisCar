package com.solutis.car.model.dto;

import com.solutis.car.model.entities.enums.Sexo;

import jakarta.persistence.InheritanceType;
import jakarta.persistence.Inheritance;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 200, message = "O nome deve ter entre 3 e 200 caracteres")
    private String nome;

    @NotNull(message = "A data de nascimento é obrigatória")
    private Date dataNascimento;

    @NotBlank(message = "O CPF é obrigatório")
    @CPF(message = "O CPF é inválido")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 digitos")
    private String cpf;

    @NotNull(message = "O sexo é obrigatório")
    private Sexo sexo;
}
