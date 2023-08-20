package com.solutis.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solutis.car.mapper.MotoristaMapper;
import com.solutis.car.model.dto.MotoristaDTO;
import com.solutis.car.model.entities.Motorista;
import com.solutis.car.repositories.MotoristaRepository;
import com.solutis.car.service.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotoristaService implements CrudService<MotoristaDTO> {

    @Autowired
    private MotoristaRepository repository;

    @Autowired
    private MotoristaMapper mapper;

    @Transactional(readOnly = true)
    public MotoristaDTO findById(Long id) {
        return this.mapper.toDto(this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Motorista não encontrado")));
    }

    @Transactional(readOnly = true)
    public List<MotoristaDTO> findAll() {
        return this.repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public MotoristaDTO add(MotoristaDTO motoristaDTO) {
        Motorista motorista = this.mapper.toEntity(motoristaDTO);
        motorista = repository.save(motorista);
        return this.mapper.toDto(motorista);
    }

    @Transactional
    public MotoristaDTO update(Long id, MotoristaDTO motoristaDTO) {
        Motorista existingMotorista = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Motorista não encontrado"));
        Motorista motoristaUpdate = this.mapper.toEntity(motoristaDTO);
        motoristaUpdate.setId(existingMotorista.getId());
        motoristaUpdate = repository.save(motoristaUpdate);
        return this.mapper.toDto(motoristaUpdate);
    }

    @Transactional
    public void deleteById(Long id) {
        Motorista motorista = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Motorista não encontrado"));
        repository.delete(motorista);
    }
}
