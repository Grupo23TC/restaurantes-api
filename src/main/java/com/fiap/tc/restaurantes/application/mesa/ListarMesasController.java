package com.fiap.tc.restaurantes.application.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.tc.restaurantes.domain.output.mesa.MesaResponse;
import com.fiap.tc.restaurantes.domain.useCase.mesa.ListarMesasUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mesas")
public class ListarMesasController {

    private final MesaMapper mesaMapper;
    private final ListarMesasUseCase listarMesasUseCase;

    @GetMapping
    public ResponseEntity<List<MesaResponse>> listarMesas() {
        List<Mesa> mesas = listarMesasUseCase.listarMesas();
        List<MesaResponse> listaMesaResponse = mesas.stream()
                .map(mesaMapper::toMesaResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(listaMesaResponse);
    }
}