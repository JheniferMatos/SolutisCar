package com.solutis.car.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;
import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface MapperBase<E, D> {
    @Mapping(target = ".", source = ".", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    D ToDTO(E entity);

    @Mapping(target = ".", source = ".", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    E ToModel(D dto);

    @Mapping(target = ".", source = ".", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<D> ToListDto(List<E> all);
}