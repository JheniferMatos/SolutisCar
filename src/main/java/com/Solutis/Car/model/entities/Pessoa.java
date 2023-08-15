package com.Solutis.Car.model.entities;

import java.util.Date;

import com.Solutis.Car.model.entities.enums.Sexo;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Data

public class Pessoa {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String nome;

	private Date dataNascimento;

	private String cpf;

	private Sexo sexo;

}
