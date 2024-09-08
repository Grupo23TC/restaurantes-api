package com.fiap.tc.restaurantes.domain.mapper.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.input.mesa.CadastrarMesaRequest;
import com.fiap.tc.restaurantes.domain.output.mesa.MesaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MesaMapper {
  MesaMapper INSTANCE = Mappers.getMapper(MesaMapper.class);

  @Mapping(target = "mesaId", ignore = true)
  Mesa toMesa(CadastrarMesaRequest cadastrarMesaRequest);

  // Mapear a entidade Mesa para a MesaResponse
  @Mapping(source = "id", target = "id")
  @Mapping(source = "numero", target = "numero")
  @Mapping(source = "capacidade", target = "capacidade")
  MesaResponse toMesaResponse(Mesa mesa);
}