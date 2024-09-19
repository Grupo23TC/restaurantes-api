package com.fiap.tc.restaurantes.application.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.mapper.avaliacao.AvaliacaoMapper;
import com.fiap.tc.restaurantes.domain.output.avaliacao.AvaliacaoResponse;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.BuscarAvaliacaoPorIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacoes")
@RequiredArgsConstructor
public class BuscarAvaliacaoPorIdController {

    private final AvaliacaoMapper avaliacaoMapper;
    private final BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase;

    @GetMapping("{id}")
    public ResponseEntity<AvaliacaoResponse> buscarAvaliacaoPorId(@PathVariable Long id) {
        Avaliacao avaliacao = buscarAvaliacaoPorIdUseCase.buscarAvalacaoPorId(id);

        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoMapper.toAvaliacaoResponse(avaliacao));
    }
}
