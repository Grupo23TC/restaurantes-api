package com.fiap.tc.restaurantes.application.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.input.mesa.AtualizarMesaRequest;
import com.fiap.tc.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.tc.restaurantes.domain.output.mesa.MesaResponse;
import com.fiap.tc.restaurantes.domain.usecase.mesa.AtualizarMesaUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mesas")
public class AtualizarMesaController {

    private final MesaMapper mesaMapper;
    private final AtualizarMesaUseCase atualizarMesaUseCase;

    public AtualizarMesaController(MesaMapper mesaMapper, AtualizarMesaUseCase atualizarMesaUseCase) {
        this.mesaMapper = mesaMapper;
        this.atualizarMesaUseCase = atualizarMesaUseCase;
    }

    @PutMapping("/{mesaId}")
    public ResponseEntity<MesaResponse> atualizarMesa(@PathVariable Long mesaId,
                                                      @RequestBody AtualizarMesaRequest mesaRequest) {
        Mesa mesaAtualizada = atualizarMesaUseCase.atualizarMesa(mesaId, mesaMapper.toMesa(mesaRequest));
        MesaResponse mesaResponse = mesaMapper.toMesaResponse(mesaAtualizada);

        return ResponseEntity.ok(mesaResponse);
    }
}