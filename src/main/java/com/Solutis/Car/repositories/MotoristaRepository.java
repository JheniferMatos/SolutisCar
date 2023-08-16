package com.solutis.car.repositories;

import com.solutis.car.model.entities.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
}