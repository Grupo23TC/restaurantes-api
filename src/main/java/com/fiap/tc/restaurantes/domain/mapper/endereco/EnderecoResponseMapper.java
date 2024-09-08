package com.fiap.tc.restaurantes.domain.mapper.endereco;

import com.fiap.tc.restaurantes.domain.output.endereco.EnderecoResponse;
import com.fiap.tc.restaurantes.domain.entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnderecoResponseMapper {

    EnderecoResponseMapper INSTANCE = Mappers.getMapper(EnderecoResponseMapper.class);

    @Mapping(target = "cidade", source = "localidade")
    Endereco toEndereco(EnderecoResponse enderecoResponse);

}
