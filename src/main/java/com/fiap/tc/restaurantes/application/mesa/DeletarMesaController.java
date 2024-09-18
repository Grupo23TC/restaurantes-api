package com.fiap.tc.restaurantes.application.mesa;

import com.fiap.tc.restaurantes.domain.usecase.mesa.DeletarMesaUseCase;
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

    private final DeletarMesaUseCase deletarMesaUseCase;

    @DeleteMapping("/{mesaId}")
    public ResponseEntity<Void> deletarMesa(@PathVariable Long mesaId) {
        deletarMesaUseCase.deletarMesa(mesaId);
        return ResponseEntity.noContent().build();
    }
}