package com.fiap.tc.restaurantes.domain.usecase.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.gateway.avaliacao.BuscarAvaliacoesPorRestauranteInterface;
import com.fiap.tc.restaurantes.domain.gateway.avaliacao.DeletarAvaliacaoInterface;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.DeletarRestauranteInterface;
import com.fiap.tc.restaurantes.infra.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.utils.avaliacao.AvaliacaoHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DeletarRestauranteUseCaseTest {
    private DeletarRestauranteUseCase useCase;

    @Mock
    private DeletarRestauranteInterface deletarRestauranteInterface;

    @Mock
    private DeletarAvaliacaoInterface deletarAvaliacaoInterface;

    @Mock
    private BuscarAvaliacoesPorRestauranteInterface buscarAvaliacoesPorRestauranteInterface;

    AutoCloseable openMocks;


    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        useCase = new DeletarRestauranteUseCase(
                deletarRestauranteInterface,
                buscarAvaliacoesPorRestauranteInterface,
                deletarAvaliacaoInterface
        );
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void devePermitirDeletarRestaurante_ComAvaliacao() {
        // Arrange
        Avaliacao avaliacao1 = AvaliacaoHelper.gerarAvaliacao();
        Avaliacao avaliacao2 = AvaliacaoHelper.gerarAvaliacao();
        Avaliacao avaliacao3 = AvaliacaoHelper.gerarAvaliacao();
        avaliacao1.setAvaliacaoId(1L);
        avaliacao2.setAvaliacaoId(2L);
        avaliacao3.setAvaliacaoId(3L);
        List<Avaliacao> avaliacoes = List.of(avaliacao1, avaliacao2, avaliacao3);
        var identificador = 1L;

        when(buscarAvaliacoesPorRestauranteInterface.buscarAvaliacoesPorRestaurante(any(Long.class))).thenReturn(avaliacoes);
        when(deletarAvaliacaoInterface.deletarAvaliacao(any(Long.class))).thenReturn(true);
        when(deletarRestauranteInterface.deletarRestaurante(any(Long.class))).thenReturn(true);


        // Act
        useCase.deletarRestaurante(identificador);

        // Assert
        verify(deletarRestauranteInterface, times(1)).deletarRestaurante(any(Long.class));
        verify(buscarAvaliacoesPorRestauranteInterface, times(1)).buscarAvaliacoesPorRestaurante(any(Long.class));
        verify(deletarAvaliacaoInterface, times(3)).deletarAvaliacao(any(Long.class));
    }

    @Test
    void devePermitirDeletarRestaurante_SemAvaliacao() {
        // Arrange
        List<Avaliacao> avaliacoes = List.of();
        var identificador = 3L;

        when(buscarAvaliacoesPorRestauranteInterface.buscarAvaliacoesPorRestaurante(any(Long.class))).thenReturn(avaliacoes);
        when(deletarRestauranteInterface.deletarRestaurante(any(Long.class))).thenReturn(true);


        // Act
        useCase.deletarRestaurante(identificador);

        // Assert
        verify(deletarRestauranteInterface, times(1)).deletarRestaurante(any(Long.class));
        verify(buscarAvaliacoesPorRestauranteInterface, times(1)).buscarAvaliacoesPorRestaurante(any(Long.class));
        verify(deletarAvaliacaoInterface, never()).deletarAvaliacao(any(Long.class));
    }
}