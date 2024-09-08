package com.fiap.tc.restaurantes.application.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.tc.restaurantes.domain.output.mesa.MesaResponse;
import com.fiap.tc.restaurantes.domain.useCase.mesa.BuscarMesaPorIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mesas")
public class BuscarMesaPorIdController {

    private final MesaMapper mesaMapper;
    private final BuscarMesaPorIdUseCase buscarMesaPorIdUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<MesaResponse> buscarMesa(@PathVariable Long id) {
        Mesa mesaBuscada = buscarMesaPorIdUseCase.buscarPorId(id);
        return ResponseEntity.ok(mesaMapper.toMesaResponse(mesaBuscada));
    }
}