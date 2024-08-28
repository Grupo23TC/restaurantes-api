package com.fiap.tc.restaurantes.adapters.in.controller.restaurante.mapper;

import com.fiap.tc.restaurantes.adapters.in.controller.restaurante.request.AtualizarRestauranteRequest;
import com.fiap.tc.restaurantes.adapters.in.controller.restaurante.request.CadastrarRestauranteRequest;
import com.fiap.tc.restaurantes.adapters.in.controller.restaurante.response.RestauranteResponse;
import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RestauranteMapper {

    RestauranteMapper INSTANCE = Mappers.getMapper(RestauranteMapper.class);

    /**
     * @param restauranteRequest
     * @return
     */
    @Mapping(target = "restauranteId", ignore = true)
    Restaurante toRestaurante(CadastrarRestauranteRequest restauranteRequest);

    @Mapping(target = "restauranteId", ignore = true)
    Restaurante toRestaurante(AtualizarRestauranteRequest restauranteRequest);

    /**
     * @param restaurante
     * @return
     */
    RestauranteResponse toRestauranteResponse(Restaurante restaurante);

}
