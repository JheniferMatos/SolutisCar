package com.solutis.car.model.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Funcionario extends Pessoa {

    private String matricula;
}
