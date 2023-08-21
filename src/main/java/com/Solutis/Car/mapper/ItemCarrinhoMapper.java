package com.solutis.car.mapper;

import com.solutis.car.model.dto.ItemCarrinhoDTO;
import com.solutis.car.model.entities.ItemCarrinho;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ItemCarrinhoMapper {

    private final ModelMapper modelMapper;

    public ItemCarrinhoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ItemCarrinhoDTO toDto(ItemCarrinho itemCarrinho) {
        return modelMapper.map(itemCarrinho, ItemCarrinhoDTO.class);
    }

    public ItemCarrinho toEntity(ItemCarrinhoDTO itemCarrinhoDTO) {
        return modelMapper.map(itemCarrinhoDTO, ItemCarrinho.class);
    }
}