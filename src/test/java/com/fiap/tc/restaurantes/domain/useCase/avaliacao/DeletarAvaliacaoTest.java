package com.fiap.tc.restaurantes.domain.useCase.avaliacao;

import com.fiap.tc.restaurantes.domain.exception.avaliacao.AvaliacaoNotFoundException;
import com.fiap.tc.restaurantes.domain.gateway.avaliacao.DeletarAvaliacaoInterface;
import com.fiap.tc.restaurantes.utils.avaliacao.AvaliacaoHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class DeletarAvaliacaoTest {

    private DeletarAvaliacaoUseCase deletarAvaliacaoUseCase;

    @Mock
    private DeletarAvaliacaoInterface deletarAvaliacaoInterface;

    @Mock
    private BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase;

    AutoCloseable mock;

    @BeforeEach
    public void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        deletarAvaliacaoUseCase = new DeletarAvaliacaoUseCase(deletarAvaliacaoInterface, buscarAvaliacaoPorIdUseCase);
    }

    @AfterEach
    public void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void devePermitirDeletarAvaliacao() {
        when(buscarAvaliacaoPorIdUseCase.execute(anyLong())).thenReturn(AvaliacaoHelper.gerarAvaliacao());
        when(deletarAvaliacaoInterface.deletarAvaliacao(anyLong())).thenReturn(true);

        var avaliacaRemovida = deletarAvaliacaoUseCase.execute(1L);

        assertThat(avaliacaRemovida).isTrue();
        verify(buscarAvaliacaoPorIdUseCase, times(1)).execute(anyLong());
        verify(deletarAvaliacaoInterface, times(1)).deletarAvaliacao(anyLong());
    }

    @Test
    void deveGerarExcecao_QuandoDeletarAvaliacao_IdNaoEncontrado() {
        when(buscarAvaliacaoPorIdUseCase.execute(anyLong())).thenThrow(new AvaliacaoNotFoundException("Avaliacao não encontrada"));

        assertThatThrownBy(() -> deletarAvaliacaoUseCase.execute(1L))
                .isInstanceOf(AvaliacaoNotFoundException.class)
                .hasMessage("Avaliacao não encontrada");
        verify(buscarAvaliacaoPorIdUseCase, times(1)).execute(anyLong());
        verify(deletarAvaliacaoInterface, never()).deletarAvaliacao(anyLong());
    }
}
