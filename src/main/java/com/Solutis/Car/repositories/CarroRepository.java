package com.solutis.car.repositories;

import com.solutis.car.model.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
