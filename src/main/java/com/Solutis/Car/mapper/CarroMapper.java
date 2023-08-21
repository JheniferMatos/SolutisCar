package com.solutis.car.mapper;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.solutis.car.model.dto.CarroDTO;
import com.solutis.car.model.entities.Carro;

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

    public CarroDTO toListDto(List<Carro> carro) {
        return  modelMapper.map(carro, CarroDTO.class);
    } }
