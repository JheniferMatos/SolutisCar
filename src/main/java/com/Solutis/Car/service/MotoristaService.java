package com.solutis.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solutis.car.model.dto.MotoristaDTO;
import com.solutis.car.model.entities.Motorista;
import com.solutis.car.repositories.MotoristaRepository;
import com.solutis.car.mapper.MotoristaMapper; 
import java.util.Optional;

@Service
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;
    private final MotoristaMapper motoristaMapper;

    @Autowired
    public MotoristaService(MotoristaRepository motoristaRepository, MotoristaMapper motoristaMapper) {
        this.motoristaRepository = motoristaRepository;
        this.motoristaMapper = motoristaMapper;
    }

    public MotoristaDTO criarMotorista(MotoristaDTO motoristaDTO) {
        Motorista motorista = motoristaMapper.toEntity(motoristaDTO);
        Motorista novoMotorista = motoristaRepository.save(motorista);
        return motoristaMapper.toDto(novoMotorista);
    }



}
