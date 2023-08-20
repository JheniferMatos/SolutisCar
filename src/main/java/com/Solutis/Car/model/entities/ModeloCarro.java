package com.solutis.car.model.entities;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solutis.car.model.entities.enums.Categoria;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
public class ModeloCarro {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank(message = "A descrição é obrigatória")
	@Size(min = 3, max = 200, message = "A descrição deve ter entre 3 e 200 caracteres")
	@Column(nullable = false)
	private String descricao;

	@OneToMany(mappedBy = "modeloCarro",cascade = CascadeType.ALL)
	private Collection<Carro> carro;

	@JsonIgnoreProperties({"modeloCarro"})
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fabricante_id", nullable = false)
	private Fabricante fabricante;

	@NotNull(message = "A categoria é obrigatória")
	@Enumerated(EnumType.STRING)
	@Column(name= "categoria", nullable = false)
	private Categoria categoria;

}

