package com.fiap.tc.restaurantes.application.mesa;

import com.fiap.tc.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.tc.restaurantes.domain.input.mesa.CadastrarMesaRequest;
import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.output.mesa.MesaResponse;
import com.fiap.tc.restaurantes.domain.useCase.mesa.CadastrarMesaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mesas")
public class CadastrarMesaController {

    private final MesaMapper mesaMapper;
    private final CadastrarMesaUseCase cadastrarMesaUseCase;

    @PostMapping
    public ResponseEntity<MesaResponse> cadastrarMesa(@RequestBody CadastrarMesaRequest cadastrarMesaRequest) {
        Mesa mesa = mesaMapper.toMesa(cadastrarMesaRequest);

        Mesa mesaCadastrada = cadastrarMesaUseCase.cadastrarMesa(mesa.getRestauranteId(), mesa.getMesaId());

        MesaResponse mesaResponse = mesaMapper.toMesaResponse(mesaCadastrada);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mesaResponse.getMesaId())
                .toUri();

        return ResponseEntity.created(uri).body(mesaResponse);
    }
}