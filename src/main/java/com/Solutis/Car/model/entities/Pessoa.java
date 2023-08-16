package com.solutis.car.model.entities;

import java.util.Date;

import com.solutis.car.model.entities.enums.Sexo;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Temporal(TemporalType.DATE) // Adicionado o @Temporal para mapear a coluna dataNascimento
    private Date dataNascimento;

    private String cpf;

    private Sexo sexo;
}
