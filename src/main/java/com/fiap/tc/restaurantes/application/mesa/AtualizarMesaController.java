package com.fiap.tc.restaurantes.application.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.input.mesa.AtualizarMesaRequest;
import com.fiap.tc.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.tc.restaurantes.domain.output.mesa.MesaResponse;
import com.fiap.tc.restaurantes.domain.useCase.mesa.AtualizarMesaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mesas")
public class AtualizarMesaController {

    private final MesaMapper mesaMapper;
    private final AtualizarMesaUseCase atualizarMesaUseCase;

    @PutMapping("/{id}")
    public ResponseEntity<MesaResponse> atualizarMesa(@PathVariable Long id,
                                                      @RequestBody AtualizarMesaRequest mesaRequest) {
        Mesa mesaAtualizada = atualizarMesaUseCase.atualizarMesa(id, mesaMapper.toMesa(mesaRequest));
        MesaResponse mesaResponse = mesaMapper.toMesaResponse(mesaAtualizada);

        return ResponseEntity.ok(mesaResponse);
    }
}