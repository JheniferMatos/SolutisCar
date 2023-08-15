package com.Solutis.Car.Entities;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
public class Funcionário extends Pessoa {

	private String matricula;

}
