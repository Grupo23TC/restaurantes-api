package com.fiap.tc.restaurantes.adapters.out.repository.mapper;

import com.fiap.tc.restaurantes.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RestauranteEntityMapper {

    RestauranteEntityMapper INSTANCE = Mappers.getMapper(RestauranteEntityMapper.class);

    /**
     * @param restaurante
     * @return
     */
    RestauranteEntity toRestauranteEntity(Restaurante restaurante);

    /**
     * @param restauranteEntity
     * @return
     */
    Restaurante toRestaurante(RestauranteEntity restauranteEntity);
}
