package com.Solutis.Car.Entities;

import java.math.BigDecimal;
import java.util.Collection;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
public class Carro {

	private String placa;

	private String chassi;

	private String cor;

	private BigDecimal valorDiaria;

	private Motorista motorista;

	private ApoliceSeguro apoliceSeguro;

	private Collection<Aluguel> aluguel;

	private Collection<Acessorio> acessorio;

	private ModeloCarro modeloCarro;

}
