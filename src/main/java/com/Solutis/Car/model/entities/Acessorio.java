package com.Solutis.Car.model.entities;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

@Data
@Entity
public class Acessorio {

	private String descricao;

	@OneToMany(mappedBy = "acessorio")
	private Collection<Carro> carro;

}
