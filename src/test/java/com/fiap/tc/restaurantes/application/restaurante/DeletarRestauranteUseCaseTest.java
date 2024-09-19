package com.fiap.tc.restaurantes.application.restaurante;

import com.fiap.tc.restaurantes.domain.gateway.restaurante.DeletarRestauranteInterface;
import com.fiap.tc.restaurantes.domain.usecase.restaurante.DeletarRestauranteUseCase;
import com.fiap.tc.restaurantes.infra.repository.RestauranteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DeletarRestauranteUseCaseTest {

    @Mock
    private RestauranteRepository repository;

    private DeletarRestauranteUseCase useCase;

    @Mock
    private DeletarRestauranteInterface deletarRestauranteInterface;

    AutoCloseable openMocks;


    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        useCase = new DeletarRestauranteUseCase(deletarRestauranteInterface);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void devePermitirDeletarRestaurante() {
        // Arrange
        var identificador = 1L;

        doNothing().when(repository).deleteById(any(Long.class));

        // Act
        useCase.deletarRestaurante(identificador);

        // Assert
        verify(deletarRestauranteInterface, times(1)).deletarRestaurante(any(Long.class));
    }
}