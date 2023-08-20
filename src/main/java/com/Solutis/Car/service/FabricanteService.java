package com.solutis.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solutis.car.mapper.FabricanteMapper;
import com.solutis.car.model.dto.FabricanteDTO;
import com.solutis.car.model.entities.Fabricante;
import com.solutis.car.repositories.FabricanteRepository;
import com.solutis.car.service.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FabricanteService implements CrudService<FabricanteDTO> {

    @Autowired
    private FabricanteRepository repository;

    @Autowired
    private FabricanteMapper mapper;

    @Transactional(readOnly = true)
    public FabricanteDTO findById(Long id) {
        return this.mapper.toDto(this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado")));
    }

    @Transactional(readOnly = true)
    public List<FabricanteDTO> findAll() {
        return this.repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public FabricanteDTO add(FabricanteDTO fabricanteDTO) {
        Fabricante fabricante = this.mapper.toEntity(fabricanteDTO);
        fabricante = repository.save(fabricante);
        return this.mapper.toDto(fabricante);
    }

    @Transactional
    public FabricanteDTO update(Long id, FabricanteDTO fabricanteDTO) {
        Fabricante existingFabricante = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado"));
        Fabricante fabricanteUpdate = this.mapper.toEntity(fabricanteDTO);
        fabricanteUpdate.setId(existingFabricante.getId());
        fabricanteUpdate = repository.save(fabricanteUpdate);
        return this.mapper.toDto(fabricanteUpdate);
    }

    @Transactional
    public void deleteById(Long id) {
        Fabricante fabricante = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Fabricante não encontrado"));
        repository.delete(fabricante);
    }
}
