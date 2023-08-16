package com.solutis.car.model.entities;

import java.util.Collection;

import com.solutis.car.model.entities.enums.Categoria;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class ModeloCarro {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String descricao;

	@OneToMany(mappedBy = "modeloCarro")
	private Collection<Carro> carro;

	private Fabricante fabricante;

	private Categoria categoria;

}
