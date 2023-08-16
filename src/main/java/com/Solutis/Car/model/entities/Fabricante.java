package com.solutis.car.model.entities;

import java.util.Collection;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "fabricante")
    private Collection<ModeloCarro> modeloCarro;
}
