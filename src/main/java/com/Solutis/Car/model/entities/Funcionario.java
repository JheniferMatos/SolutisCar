package com.solutis.car.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Funcionario extends Pessoa {
    
    @NotBlank(message = "A matrícula é obrigatória")
    @Column(nullable = false, unique = true)
    @Size(min = 3, max = 20, message = "A matrícula deve ter entre 3 e 20 caracteres")
    private String matricula;
}
