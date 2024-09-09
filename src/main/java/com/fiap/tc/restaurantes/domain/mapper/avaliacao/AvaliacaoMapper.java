package com.fiap.tc.restaurantes.domain.mapper.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.input.avaliacao.AtualizarAvaliacaoRequest;
import com.fiap.tc.restaurantes.domain.input.avaliacao.CadastrarAvaliacaoRequest;
import com.fiap.tc.restaurantes.domain.output.avaliacao.AvaliacaoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AvaliacaoMapper {

    AvaliacaoMapper INSTANCE = Mappers.getMapper(AvaliacaoMapper.class);

    /**
     * @param avaliacaoRequest
     * @return
     */
    @Mapping(target = "avaliacaoId", ignore = true)
    @Mapping(target = "restaurante.restauranteId", source = "restauranteId")
    @Mapping(target = "usuario.usuarioId", source = "usuarioId")
    Avaliacao toAvaliacao(CadastrarAvaliacaoRequest avaliacaoRequest);

    /**
     * @param avaliacaoRequest
     * @return
     */
    @Mapping(target = "avaliacaoId", ignore = true)
    @Mapping(target = "restaurante.restauranteId", source = "restauranteId")
    @Mapping(target = "usuario.usuarioId", source = "usuarioId")
    Avaliacao toAvaliacao(AtualizarAvaliacaoRequest avaliacaoRequest);

    /**
     * @param avaliacao
     * @return
     */
    @Mapping(target = "restauranteId", source = "restaurante.restauranteId")
    @Mapping(target = "usuarioId", source = "usuario.usuarioId")
    AvaliacaoResponse toAvaliacaoResponse(Avaliacao avaliacao);
}
