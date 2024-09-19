package com.fiap.tc.restaurantes.domain.usecase.restaurante.integracao;

import com.fiap.tc.restaurantes.domain.usecase.restaurante.DeletarRestauranteUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DeletarRestauranteUseCaseIT {

    @Autowired
    private DeletarRestauranteUseCase deletarRestauranteUseCase;

    // TODO: Deletar avaliação do restaurante
//    @Test
//    void deveDeletarRestaurante() {
//        // Arrange
//        Long id = 2L;
//
//        // Act
//        boolean restauranteFoiDeletado = deletarRestauranteUseCase.deletarRestaurante(id);
//
//        // Assert
//        assertThat(restauranteFoiDeletado).isTrue();
//    }
}
