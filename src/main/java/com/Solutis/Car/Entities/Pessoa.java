package com.Solutis.Car.Entities;

import java.util.Date;
import lombok.*;

import com.Solutis.Car.Entities.enums.Sexo;

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
