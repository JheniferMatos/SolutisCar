package com.solutis.car.model.entities;

import java.math.BigDecimal;
import java.util.Collection;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Carro {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String placa;

	private String chassi;

	private String cor;

	private BigDecimal valorDiaria;

	@OneToOne
	private Motorista motorista;

	@OneToOne
	private ApoliceSeguro apoliceSeguro;

	private Collection<Aluguel> aluguel;

	private Collection<Acessorio> acessorio;

	private ModeloCarro modeloCarro;

}
