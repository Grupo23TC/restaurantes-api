package com.fiap.tc.restaurantes.infra.repository.mapper;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.infra.entity.MesaEntity;
import com.fiap.tc.restaurantes.infra.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MesaEntityMapper {

    MesaEntityMapper INSTANCE = Mappers.getMapper(MesaEntityMapper.class);

    /**
     * @param mesa
     * @return
     */

    MesaEntity toMesaEntity (Mesa mesa);

    /**
     * @param mesaEntity
     * @return
     */

    Mesa toMesa(MesaEntity mesaEntity);


}
