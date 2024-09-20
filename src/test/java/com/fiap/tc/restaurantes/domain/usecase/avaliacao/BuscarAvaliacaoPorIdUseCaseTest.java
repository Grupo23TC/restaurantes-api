package com.fiap.tc.restaurantes.domain.usecase.avaliacao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.exception.avaliacao.AvaliacaoNotFoundException;
import com.fiap.tc.restaurantes.domain.gateway.avaliacao.BuscarAvaliacaoPorIdInterface;
import com.fiap.tc.restaurantes.utils.avaliacao.AvaliacaoHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class BuscarAvaliacaoPorIdUseCaseTest {

    private BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase;

    @Mock
    private BuscarAvaliacaoPorIdInterface buscarAvaliacaoPorIdInterface;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        buscarAvaliacaoPorIdUseCase = new BuscarAvaliacaoPorIdUseCase(buscarAvaliacaoPorIdInterface);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void devePermitirBuscarAvaliacaoPorId() {
        var avaliacao = AvaliacaoHelper.gerarAvaliacao();
        when(buscarAvaliacaoPorIdInterface.buscarAvaliacaoPorId(anyLong())).thenReturn(avaliacao);

        var avaliacaoObtida = buscarAvaliacaoPorIdUseCase.buscarAvaliacaoPorId(1L);

        assertThat(avaliacaoObtida)
                .isInstanceOf(Avaliacao.class)
                .isNotNull();
        assertThat(avaliacaoObtida.getDataAvaliacao()).isEqualTo(avaliacao.getDataAvaliacao());
        assertThat(avaliacaoObtida.getNota()).isEqualTo(avaliacao.getNota());
        assertThat(avaliacaoObtida.getComentario()).isEqualTo(avaliacao.getComentario());
        assertThat(avaliacaoObtida.getRestaurante()).isEqualTo(avaliacao.getRestaurante());
        assertThat(avaliacaoObtida.getUsuario()).isEqualTo(avaliacao.getUsuario());
        verify(buscarAvaliacaoPorIdInterface, times(1)).buscarAvaliacaoPorId(anyLong());
    }

    @Test
    void deveGerarExcecao_QuandoBuscarAvaliacaoPorId_IdNaoEncontrado() {
        when(buscarAvaliacaoPorIdInterface.buscarAvaliacaoPorId(anyLong())).thenReturn(null);

        assertThatThrownBy(() -> buscarAvaliacaoPorIdUseCase.buscarAvaliacaoPorId(1L))
                .isInstanceOf(AvaliacaoNotFoundException.class)
                .hasMessage("Avaliação de id: " + 1L + " não encontrada.");
    }
}
