package com.solutis.car.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Funcionario extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String matricula;
}
