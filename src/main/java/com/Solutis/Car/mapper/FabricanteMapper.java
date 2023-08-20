package com.solutis.car.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.solutis.car.model.entities.Fabricante;
import com.solutis.car.model.dto.FabricanteDTO;

@Component
public class FabricanteMapper {

    private final ModelMapper modelMapper;

    public FabricanteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FabricanteDTO toDto(Fabricante fabricante) {
        return modelMapper.map(fabricante, FabricanteDTO.class);
    }

    public Fabricante toEntity(FabricanteDTO fabricanteDTO) {
        return modelMapper.map(fabricanteDTO, Fabricante.class);
    }
}
