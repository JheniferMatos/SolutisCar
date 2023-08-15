package com.Solutis.Car.model.entities;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
public class ApoliceSeguro {

	private BigDecimal valorFranquia;

	private boolean protecaoTerceiro;

	private boolean protecaoCausasNaturais;

	private boolean protecaoRoubo;

	private Carro carro;

	private Aluguel aluguel;

}
