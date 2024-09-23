package com.fiap.tc.restaurantes.application.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.input.avaliacao.CadastrarAvaliacaoRequest;
import com.fiap.tc.restaurantes.domain.mapper.avaliacao.AvaliacaoMapper;
import com.fiap.tc.restaurantes.domain.output.avaliacao.AvaliacaoResponse;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.CadastrarAvaliacaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacoes")
@RequiredArgsConstructor
public class CadastrarAvaliacaoController {

    private final AvaliacaoMapper avaliacaoMapper;
    private final CadastrarAvaliacaoUseCase cadastrarAvaliacaoUseCase;

    @PostMapping
    public ResponseEntity<AvaliacaoResponse> cadastrarAvaliacao(@RequestBody CadastrarAvaliacaoRequest cadastrarAvaliacaoRequest) {

        Avaliacao avaliacao = avaliacaoMapper.toAvaliacao(cadastrarAvaliacaoRequest);
        avaliacao = cadastrarAvaliacaoUseCase.cadastrarAvaliacao(avaliacao, cadastrarAvaliacaoRequest.restauranteId(), cadastrarAvaliacaoRequest.usuarioId());
        AvaliacaoResponse response = avaliacaoMapper.toAvaliacaoResponse(avaliacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
