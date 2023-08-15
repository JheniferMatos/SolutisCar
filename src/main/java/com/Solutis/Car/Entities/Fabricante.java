package com.Solutis.Car.Entities;

import java.util.Collection;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
public class Fabricante {

	private String nome;

	private Collection<ModeloCarro> modeloCarro;

}
