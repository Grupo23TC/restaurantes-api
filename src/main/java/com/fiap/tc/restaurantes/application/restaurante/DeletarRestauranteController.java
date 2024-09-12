package com.fiap.tc.restaurantes.application.restaurante;

import com.fiap.tc.restaurantes.domain.mapper.restaurante.RestauranteMapper;
import com.fiap.tc.restaurantes.domain.usecase.restaurante.DeletarRestauranteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantes")
@RequiredArgsConstructor
public class DeletarRestauranteController {

    private final RestauranteMapper restauranteMapper;
    private final DeletarRestauranteUseCase deletarRestauranteUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarRestaurante(@PathVariable Long id) {
        //TODO implementar json de restaurante deletado
        Boolean foiDeletado = deletarRestauranteUseCase.deletarRestaurante(id);
        return ResponseEntity.status(HttpStatus.OK).body(foiDeletado);
    }
}
