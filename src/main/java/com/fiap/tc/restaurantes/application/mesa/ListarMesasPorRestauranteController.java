package com.fiap.tc.restaurantes.application.mesa;

import com.fiap.tc.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.tc.restaurantes.domain.output.mesa.MesaResponse;
import com.fiap.tc.restaurantes.domain.usecase.mesa.ListarMesasPorRestauranteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mesas")
public class ListarMesasPorRestauranteController {

    private final MesaMapper mesaMapper;
    private final ListarMesasPorRestauranteUseCase listarMesasPorRestauranteUseCase;

    @GetMapping("/restaurante")
    public ResponseEntity<List<MesaResponse>> listarMesas(@RequestParam Long restauranteId) {
        List<MesaResponse> listarMesas = listarMesasPorRestauranteUseCase.listarMesasPorRestaurante(restauranteId)
                .stream()
                .map(mesaMapper::toMesaResponse)
                .toList();

        return ResponseEntity.ok(listarMesas);
    }
}