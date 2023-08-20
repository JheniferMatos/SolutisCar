package com.solutis.car.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.solutis.car.model.entities.ModeloCarro;
import com.solutis.car.model.dto.ModeloCarroDTO;

@Component
public class ModeloCarroMapper {

    private final ModelMapper modelMapper;

    public ModeloCarroMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ModeloCarroDTO toDto(ModeloCarro modeloCarro) {
        return modelMapper.map(modeloCarro, ModeloCarroDTO.class);
    }

    public ModeloCarro toEntity(ModeloCarroDTO modeloCarroDTO) {
        return modelMapper.map(modeloCarroDTO, ModeloCarro.class);
    }
}
