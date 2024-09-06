package com.fiap.tc.restaurantes.domain.mapper.restaurante;

import com.fiap.tc.restaurantes.domain.input.restaurante.AtualizarRestauranteRequest;
import com.fiap.tc.restaurantes.domain.input.restaurante.CadastrarRestauranteRequest;
import com.fiap.tc.restaurantes.domain.output.restaurante.RestauranteResponse;
import com.fiap.tc.restaurantes.domain.entity.Restaurante;
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
