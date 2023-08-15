package com.Solutis.Car.model.entities;

import java.math.BigDecimal;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@Entity
public class Carro {

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
