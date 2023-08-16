package com.solutis.car.repositories;

import com.solutis.car.model.entities.Acessorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {
}