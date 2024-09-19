package com.fiap.tc.restaurantes.application.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.usecase.restaurante.CadastrarRestauranteUseCase;
import com.fiap.tc.restaurantes.utils.restaurante.RestauranteHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CadastrarRestauranteUseCaseIT {

    @Autowired
    private CadastrarRestauranteUseCase cadastrarRestauranteUseCase;

    @Test
    void deveCadastrarRestaurante() {
        // Arrange
        Restaurante restaurante = RestauranteHelper.gerarRestauranteValido();

        // Act
        Restaurante restauranteSalvo = cadastrarRestauranteUseCase.cadastrarRestaurante(restaurante);

        // Assert
        assertThat(restauranteSalvo)
                .isNotNull()
                .isInstanceOf(Restaurante.class);

        assertThat(restauranteSalvo.getRestauranteId())
                .isNotNull()
                .isPositive();

        assertThat(restauranteSalvo.getNome())
                .isEqualTo(restaurante.getNome());

    }
}
