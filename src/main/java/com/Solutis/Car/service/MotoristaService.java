package com.solutis.car.service;

import org.springframework.stereotype.Service;
import com.solutis.car.model.dto.MotoristaDTO;
import com.solutis.car.model.entities.Motorista;
import com.solutis.car.repositories.MotoristaRepository;
import com.solutis.car.mapper.MotoristaMapper;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;
    private final MotoristaMapper motoristaMapper;

    public MotoristaService(MotoristaRepository motoristaRepository, MotoristaMapper motoristaMapper) {
        this.motoristaRepository = motoristaRepository;
        this.motoristaMapper = motoristaMapper;
    }

    // Criar motorista
    public MotoristaDTO criarMotorista(MotoristaDTO motoristaDTO) {
        Motorista motorista = motoristaMapper.toEntity(motoristaDTO);
        Motorista novoMotorista = motoristaRepository.save(motorista);
        return motoristaMapper.toDto(novoMotorista);
    }

    // Obter motorista por id
    public Optional<MotoristaDTO> obterMotoristaPorId(Long id) {
        Optional<Motorista> motorista = motoristaRepository.findById(id);
        return motorista.map(motoristaMapper::toDto);
    }

    public List<MotoristaDTO> listarMotoristas() {
    List<Motorista> motoristas = motoristaRepository.findAll();
    List<MotoristaDTO> motoristasDTO = new ArrayList<>();

    for (Motorista motorista : motoristas) {
        motoristasDTO.add(motoristaMapper.toDto(motorista));
    }

    return motoristasDTO;
}



}
