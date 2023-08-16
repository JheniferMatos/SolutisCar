package com.solutis.car.model.entities;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class ApoliceSeguro {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private BigDecimal valorFranquia;

	private boolean protecaoTerceiro;

	private boolean protecaoCausasNaturais;

	private boolean protecaoRoubo;

	private Carro carro;

	private Aluguel aluguel;

}
