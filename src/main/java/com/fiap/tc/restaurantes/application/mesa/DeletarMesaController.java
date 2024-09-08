package com.fiap.tc.restaurantes.application.mesa;

import com.fiap.tc.restaurantes.domain.mapper.mesa.MesaMapper;
import com.fiap.tc.restaurantes.domain.output.mesa.MesaDeletadaResponse;
import com.fiap.tc.restaurantes.domain.useCase.mesa.DeletarMesaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mesas")
public class DeletarMesaController {

    private final MesaMapper mesaMapper;
    private final DeletarMesaUseCase deletarMesaUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<MesaDeletadaResponse> deletarMesa(@PathVariable Long id) {
        boolean mesaFoiDeletada = deletarMesaUseCase.deletarMesa(id);
        return ResponseEntity.ok(new MesaDeletadaResponse(mesaFoiDeletada));
    }
}