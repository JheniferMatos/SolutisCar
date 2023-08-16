package com.solutis.car.model.entities;

import java.util.Collection;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
public class Acessorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;

	@OneToMany(mappedBy = "acessorio")
	private Collection<Carro> carro;

}
