package com.Solutis.Car.model.entities;

import java.util.Collection;

import com.Solutis.Car.model.entities.enums.Categoria;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

@Data
@Entity
public class ModeloCarro {

	private String descricao;

	@OneToMany(mappedBy = "modeloCarro")
	private Collection<Carro> carro;

	private Fabricante fabricante;

	private Categoria categoria;

}
