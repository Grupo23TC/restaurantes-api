package com.fiap.tc.restaurantes.application.avaliacao;

import com.fiap.tc.restaurantes.domain.mapper.avaliacao.AvaliacaoMapper;
import com.fiap.tc.restaurantes.domain.output.avaliacao.AvaliacaoResponse;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.BuscarAvaliacoesPorRestauranteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
@RequiredArgsConstructor
public class BuscarAvaliacoesPorRestauranteController {

    private final AvaliacaoMapper avaliacaoMapper;
    private final BuscarAvaliacoesPorRestauranteUseCase buscarAvaliacoesPorRestauranteUseCase;

    @GetMapping("/restaurante")
    public ResponseEntity<List<AvaliacaoResponse>> buscarAvaliacoesPorRestaurante(@RequestParam Long restauranteId) {

        List<AvaliacaoResponse> avaliacaoResponseList = buscarAvaliacoesPorRestauranteUseCase.execute(restauranteId)
                .stream()
                .map(avaliacaoMapper::toAvaliacaoResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoResponseList);
    }
}
