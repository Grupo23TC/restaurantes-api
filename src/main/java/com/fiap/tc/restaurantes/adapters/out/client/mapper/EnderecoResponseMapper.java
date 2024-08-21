package com.fiap.tc.restaurantes.adapters.out.client.mapper;

import com.fiap.tc.restaurantes.adapters.out.client.response.EnderecoResponse;
import com.fiap.tc.restaurantes.application.core.domain.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnderecoResponseMapper {

    EnderecoResponseMapper INSTANCE = Mappers.getMapper(EnderecoResponseMapper.class);

    @Mapping(target = "cidade", source = "localidade")
    Endereco toEndereco(EnderecoResponse enderecoResponse);

}
