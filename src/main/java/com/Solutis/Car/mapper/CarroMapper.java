package com.solutis.car.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.solutis.car.model.dto.CarroDTO;
import com.solutis.car.model.entities.Carro;
import com.solutis.car.model.dto.AcessorioDTO;
import com.solutis.car.model.entities.Acessorio;
import com.solutis.car.model.dto.ModeloCarroDTO;
import com.solutis.car.model.entities.ModeloCarro;
import com.solutis.car.model.dto.FabricanteDTO;
import com.solutis.car.model.entities.Fabricante;

@Component
public class CarroMapper {

    private final ModelMapper modelMapper;

    public CarroMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CarroDTO toDto(Carro carro) {
        return modelMapper.map(carro, CarroDTO.class);
    }

    public Carro toEntity(CarroDTO carroDTO) {
        return modelMapper.map(carroDTO, Carro.class);
    }

    public Acessorio toEntity(AcessorioDTO acessorioDTO) {
        return modelMapper.map(acessorioDTO, Acessorio.class);
    }

    public ModeloCarro toEntity(ModeloCarroDTO modeloCarroDTO) {
        return modelMapper.map(modeloCarroDTO, ModeloCarro.class);
    }

    public Fabricante toEntity(FabricanteDTO fabricanteDTO) {
        return modelMapper.map(fabricanteDTO, Fabricante.class);
    }

    // Additional mapping methods for other entities
}
