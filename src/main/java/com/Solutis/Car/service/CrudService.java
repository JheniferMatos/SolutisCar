package com.solutis.car.service;
import java.util.List;

public interface CrudService<T> {
    
    T findById(Long id);

    List<T> findAll();

    T add(T payload);

    T update(Long id,T payload);

    void deleteById(Long id);
}
