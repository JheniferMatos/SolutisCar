package com.Solutis.Car.model.entities;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

@Data
@Entity
public class Fabricante {

    private String nome;

    @OneToMany(mappedBy = "fabricante")
    private Collection<ModeloCarro> modeloCarro;
}
