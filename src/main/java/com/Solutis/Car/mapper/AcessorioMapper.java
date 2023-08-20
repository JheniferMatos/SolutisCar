package com.solutis.car.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.solutis.car.model.dto.AcessorioDTO;
import com.solutis.car.model.entities.Acessorio;

@Component
public class AcessorioMapper {

    private final ModelMapper modelMapper;

    public AcessorioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AcessorioDTO toDto(Acessorio acessorio) {
        return modelMapper.map(acessorio, AcessorioDTO.class);
    }

    public Acessorio toEntity(AcessorioDTO acessorioDTO) {
        return modelMapper.map(acessorioDTO, Acessorio.class);
    }
}
