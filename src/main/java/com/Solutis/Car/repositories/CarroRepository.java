package com.solutis.car.repositories;

import com.solutis.car.model.entities.Carro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarroRepository extends JpaRepository<Carro, Long> {

   @Query("SELECT DISTINCT c FROM Carro c " +
       "JOIN c.acessorios a " +
       "WHERE (:categoria IS NULL OR c.modeloCarro.categoria = :categoria) " +
       "AND (COALESCE(:acessorios, NULL) IS NULL OR " +
       "a.id IN :acessorios OR LOWER(a.descricao) IN :acessorios)")
List<Carro> findVeiculosDisponiveis(@Param("categoria") String categoria, @Param("acessorios") List<String> acessorios);
}