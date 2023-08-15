package com.Solutis.Car.model.entities;

import java.util.Date;

import com.Solutis.Car.model.entities.enums.Sexo;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Temporal(TemporalType.DATE) // Adicionado o @Temporal para mapear a coluna dataNascimento
    private Date dataNascimento;

    private String cpf;

    private Sexo sexo;
}
