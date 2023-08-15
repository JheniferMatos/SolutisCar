package com.Solutis.Car.model.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
public class Aluguel {

	private Calendar dataPedido;

	private Date dataEntrega;

	private Date dataDevolucao;

	private BigDecimal valorTotal;

	private Carro carro;

	private Motorista motorista;

	private ApoliceSeguro apoliceSeguro;

}
