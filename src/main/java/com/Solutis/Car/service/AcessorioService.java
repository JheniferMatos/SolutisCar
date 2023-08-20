package com.solutis.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.solutis.car.mapper.AcessorioMapper;
import com.solutis.car.model.dto.AcessorioDTO;

import com.solutis.car.model.entities.Acessorio;

import com.solutis.car.repositories.AcessorioRepository;

import com.solutis.car.service.exception.NotFoundException;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcessorioService implements CrudService<AcessorioDTO> {

    @Autowired
    private AcessorioRepository repository;

    @Autowired
    private AcessorioMapper mapper;

    @Transactional(readOnly = true)
    public AcessorioDTO findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Acessório não encontrado")));
    }

    @Transactional(readOnly = true)
    public List<AcessorioDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    // @Transactional
    // public AcessorioDTO criarAcessorioCompleto(AcessorioDTO acessorioDTO) {
    //     List<Carro> carros = new ArrayList<>();
    //     for (Long carroId : carroIds) {
    //         Carro carro = carroRepository.findById(carroId)
    //                 .orElseThrow(() -> new NotFoundException("Carro não encontrado"));
    //         carros.add(carro);
    //     }

    //     Acessorio acessorio = mapper.toEntity(acessorioDTO);
    //     acessorio.setCarro(carros);

    //     Acessorio acessorioCriado = repository.save(acessorio);
    //     return mapper.toDto(acessorioCriado);
    // }

    @Transactional
    public AcessorioDTO add(AcessorioDTO acessorioDTO) {
        Acessorio acessorio = mapper.toEntity(acessorioDTO);
        acessorio = repository.save(acessorio);
        return mapper.toDto(acessorio);
    }

    @Transactional
    public AcessorioDTO update(Long id, AcessorioDTO acessorioDTO) {
        Acessorio existingAcessorio = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Acessório não encontrado"));
        Acessorio acessorioUpdate = mapper.toEntity(acessorioDTO);
        acessorioUpdate.setId(existingAcessorio.getId());
        acessorioUpdate = repository.save(acessorioUpdate);
        return mapper.toDto(acessorioUpdate);
    }

    @Transactional
    public void deleteById(Long id) {
        Acessorio acessorio = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Acessório não encontrado"));
        repository.delete(acessorio);
    }
}
