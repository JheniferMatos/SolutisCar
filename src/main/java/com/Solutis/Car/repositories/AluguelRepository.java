package com.solutis.car.repositories;

import com.solutis.car.model.entities.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
