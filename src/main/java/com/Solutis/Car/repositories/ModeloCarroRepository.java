package com.solutis.car.repositories;

import com.solutis.car.model.entities.ModeloCarro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
    
}