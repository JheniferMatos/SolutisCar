package com.solutis.car.model.entities;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@Entity
public class Acessorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "A descrição é obrigatória")
	@Size(min = 3, max = 200, message = "A descrição deve ter entre 3 e 200 caracteres")
	@Column(nullable = false)
	private String descricao;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "carro_acessorio", joinColumns = @JoinColumn(name = "acessorio_id"), inverseJoinColumns = @JoinColumn(name = "carro_id"))
	private Collection<Carro> carro;

}
