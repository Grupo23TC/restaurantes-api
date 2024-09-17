package com.fiap.tc.restaurantes.application.mesa;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.tc.restaurantes.domain.output.mesa.MesaResponse;
import com.fiap.tc.restaurantes.domain.usecase.mesa.ListarMesasUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mesas")
public class ListarMesasController {

    private final MesaMapper mesaMapper;
    private final ListarMesasUseCase listarMesasUseCase;
    private final Restaurante restaurante;

    @GetMapping
    public ResponseEntity<List<MesaResponse>> listarMesas() {
        List<MesaResponse> listarMesas = listarMesasUseCase.listarMesasPorRestaurante(restaurante.getRestauranteId()).stream().map(mesaMapper::toMesaResponse).toList();

        return ResponseEntity.ok(listarMesas);
    }
}