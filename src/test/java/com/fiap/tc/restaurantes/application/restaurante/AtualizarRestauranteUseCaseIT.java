package com.fiap.tc.restaurantes.application.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.usecase.restaurante.AtualizarRestauranteUseCase;
import com.fiap.tc.restaurantes.utils.restaurante.RestauranteHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AtualizarRestauranteUseCaseIT {

    @Autowired
    private AtualizarRestauranteUseCase atualizarRestauranteUseCase;

    @Test
    void deveAtualizarRestaurante() {
        // Arrange
        Restaurante restaurante = RestauranteHelper.gerarRestauranteValido();
        Long id = 1L;

        // Act
        Restaurante restauranteAtualizado = atualizarRestauranteUseCase.atualizarRestaurante(id, restaurante);

        // Assert
        assertThat(restauranteAtualizado)
                .isNotNull()
                .isInstanceOf(Restaurante.class);

        assertThat(restauranteAtualizado.getNome())
                .isEqualTo(restaurante.getNome());
    }
}
