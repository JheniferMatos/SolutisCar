package com.solutis.car.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.solutis.car.model.entities.Motorista;
import com.solutis.car.model.dto.MotoristaDTO;

@Component
public class MotoristaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public MotoristaDTO toDto(Motorista motorista) {
        return modelMapper.map(motorista, MotoristaDTO.class);
    }

    public Motorista toEntity(MotoristaDTO motoristaDTO) {
        return modelMapper.map(motoristaDTO, Motorista.class);
    }
}
