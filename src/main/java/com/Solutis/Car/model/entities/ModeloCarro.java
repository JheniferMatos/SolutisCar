package com.solutis.car.model.entities;

import java.util.Collection;

import com.solutis.car.model.entities.enums.Categoria;

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
