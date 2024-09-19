package com.fiap.tc.restaurantes.application.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.BuscarRestaurantePorLocalidadeInterface;
import com.fiap.tc.restaurantes.domain.usecase.restaurante.BuscarRestaurantePorLocalidadeUseCase;
import com.fiap.tc.restaurantes.utils.restaurante.RestauranteHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BuscarRestaurantePorLocalidadeUseCaseTest {

    private BuscarRestaurantePorLocalidadeUseCase useCase;

    @Mock
    private BuscarRestaurantePorLocalidadeInterface buscarRestaurantePorLocalidadeInterface;

    AutoCloseable openMocks;


    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        useCase = new BuscarRestaurantePorLocalidadeUseCase(buscarRestaurantePorLocalidadeInterface);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void devePermitirbuscarRestaurantePorLocalidade() {
        // Arrange
        Restaurante entidade1 = RestauranteHelper.gerarRestauranteValido();
        Restaurante entidade2 = RestauranteHelper.gerarRestauranteValido();

        String rua = "Rua Teste";

        List<Restaurante> restaurantes = Arrays.asList(entidade1, entidade2);

        when(buscarRestaurantePorLocalidadeInterface.buscarRestaurantePorLocalidade(any())).thenReturn(restaurantes);

        //Act
        List<Restaurante> resultado = useCase.buscarRestaurantePorLocalidade(rua);

        // Assert
        assertThat(resultado)
                .hasSize(2)
                .containsExactlyInAnyOrder(entidade1, entidade2);

        assertThat(resultado.get(0).getEndereco().getRua())
                .isEqualTo(entidade1.getEndereco().getRua());

        assertThat(resultado.get(1).getEndereco().getRua())
                .isEqualTo(entidade1.getEndereco().getRua());

        verify(buscarRestaurantePorLocalidadeInterface, times(1)).buscarRestaurantePorLocalidade(any());
    }
}