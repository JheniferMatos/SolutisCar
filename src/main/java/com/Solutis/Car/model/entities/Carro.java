package com.solutis.car.model.entities;

import java.math.BigDecimal;

import java.util.Collection;

import java.util.List;

import com.solutis.car.model.dto.CarroDTO;
import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.solutis.car.model.dto.FabricanteDTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "A placa é obrigatória")
	@Size(min = 7, max = 7, message = "A placa deve ter 7 caracteres")
	@Column(nullable = false, unique = true)
	private String placa;

	@NotBlank(message = "O chassi é obrigatório")
	@Size(min = 17, max = 17, message = "O chassi deve ter 17 caracteres")
	@Column(nullable = false, unique = true)
	private String chassi;

	@NotBlank(message = "A cor é obrigatória")
	@Size(min = 3, max = 200, message = "A cor deve ter entre 3 e 200 caracteres")
	private String cor;

	@NotNull(message = "O valor da diária é obrigatório")
	@Column(nullable = false)
	private BigDecimal valorDiaria;

	@NotBlank(message = "A imagem é obrigatória")
	@Size(min = 3, max = 200, message = "A imagem deve ter entre 3 e 200 caracteres")
	@URL(message = "A imagem deve ser uma URL válida")
	@Column(nullable = false)
	private String imageUrl;

	// @OneToOne
	// private ApoliceSeguro apoliceSeguro;

	@JsonIgnoreProperties("carro")
	@OneToMany(mappedBy = "carro")
	private Collection<Aluguel> aluguel;

	private boolean alugado;

	@JsonIgnore
	@OneToMany(mappedBy = "carro", cascade = CascadeType.ALL)
	private List<Acessorio> acessorios;

	@JsonIgnoreProperties("carro")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "modelo_carro_id", nullable = false)
	private ModeloCarro modeloCarro;
	private FabricanteDTO fabricante;


	public Carro(CarroDTO carroDTO) {
	this.placa = carroDTO.getPlaca();
	this.chassi = carroDTO.getChassi();
	this.cor = carroDTO.getCor();
	this.valorDiaria = carroDTO.getValorDiaria();
	// this.modeloCarro = modeloCarro;
	this.alugado = false;
	// this.acessorios = acessorios;
	this.imageUrl = carroDTO.getImageUrl();
	}
}
