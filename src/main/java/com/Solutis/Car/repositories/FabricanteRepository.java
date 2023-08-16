package com.solutis.car.repositories;

import com.solutis.car.model.entities.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}