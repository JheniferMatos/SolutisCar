package com.Solutis.Car.model.entities;

import java.util.Collection;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
public class Motorista extends Pessoa {

	private String numeroCNH;

	private Collection<Carro> carro;

	private Collection<Aluguel> aluguel;

}
