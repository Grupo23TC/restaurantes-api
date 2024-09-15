package com.fiap.tc.restaurantes.domain.mapper.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.input.mesa.AtualizarMesaRequest;
import com.fiap.tc.restaurantes.domain.input.mesa.CadastrarMesaRequest;
import com.fiap.tc.restaurantes.domain.input.usuario.CadastrarUsuarioRequest;
import com.fiap.tc.restaurantes.domain.output.mesa.MesaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MesaMapper {
  MesaMapper INSTANCE = Mappers.getMapper(MesaMapper.class);

  @Mapping(target = "mesaId", ignore = true)
  Mesa toMesa(CadastrarMesaRequest cadastrarMesaRequest);

  @Mapping(target = "mesaId", ignore = true)
  Mesa toMesa(AtualizarMesaRequest atualizarMesaRequest);

  @Mapping(source = "mesaId", target = "id")
  @Mapping(source = "quantidadeAssentos", target = "capacidade")
  MesaResponse toMesaResponse(Mesa mesa);
}