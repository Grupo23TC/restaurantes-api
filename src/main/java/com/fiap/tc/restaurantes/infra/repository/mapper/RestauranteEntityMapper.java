package com.fiap.tc.restaurantes.infra.repository.mapper;

import com.fiap.tc.restaurantes.infra.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RestauranteEntityMapper {

    RestauranteEntityMapper INSTANCE = Mappers.getMapper(RestauranteEntityMapper.class);

    /**
     * @param restaurante
     * @return
     */
    @Mapping(target = "mesas", ignore = true)
    RestauranteEntity toRestauranteEntity(Restaurante restaurante);

    /**
     * @param restauranteEntity
     * @return
     */
    @Mapping(target = "mesas", ignore = true)
    Restaurante toRestaurante(RestauranteEntity restauranteEntity);
}
