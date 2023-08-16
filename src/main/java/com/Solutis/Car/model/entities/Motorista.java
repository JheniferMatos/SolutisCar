package com.solutis.car.model.entities;

import java.util.Collection;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
public class Motorista extends Pessoa {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String numeroCNH;

	private Collection<Carro> carro;

	private Collection<Aluguel> aluguel;

}
