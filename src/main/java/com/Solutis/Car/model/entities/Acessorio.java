package com.Solutis.Car.model.entities;

import java.util.Collection;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
public class Acessorio {

	private String descricao;

	private Collection<Carro> carro;

}
