package com.solutis.car.model.entities;

import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Entity
public class ApoliceSeguro {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotBlank(message = "O valor da franquia é obrigatório")
	@Column(nullable = false)
	private BigDecimal valorFranquia;
	
	private boolean protecaoTerceiro = false;

	private boolean protecaoCausasNaturais = false;

	private boolean protecaoRoubo = false;

	@OneToOne(mappedBy = "apoliceSeguro") 
	private Aluguel aluguel;

}
