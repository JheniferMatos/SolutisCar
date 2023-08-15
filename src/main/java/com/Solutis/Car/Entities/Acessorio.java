package com.Solutis.Car.Entities;

import java.util.Collection;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
public class Acessorio {

	private String descricao;

	private Collection<Carro> carro;

}
