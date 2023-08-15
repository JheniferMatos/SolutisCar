package com.Solutis.Car.model.entities;

import java.util.Collection;

import com.Solutis.Car.model.entities.enums.Categoria;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
public class ModeloCarro {

	private String descricao;

	private Collection<Carro> carro;

	private Fabricante fabricante;

	private Categoria categoria;

}
