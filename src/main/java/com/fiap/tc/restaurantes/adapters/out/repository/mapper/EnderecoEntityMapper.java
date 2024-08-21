package com.fiap.tc.restaurantes.adapters.out.repository.mapper;

import com.fiap.tc.restaurantes.adapters.out.repository.entity.EnderecoEntity;
import com.fiap.tc.restaurantes.application.core.domain.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnderecoEntityMapper {

    EnderecoEntityMapper INSTANCE = Mappers.getMapper(EnderecoEntityMapper.class);

    /**
     * @param enderecoEntity
     * @return
     */
    Endereco toEndereco(EnderecoEntity enderecoEntity);
    /**
     * @param endereco
     * @return
     */
    EnderecoEntity toEnderecoEntity(Endereco endereco);
}



