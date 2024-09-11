package com.fiap.tc.restaurantes.domain.useCase.avaliacao.integracao;

import com.fiap.tc.restaurantes.domain.exception.avaliacao.AvaliacaoNotFoundException;
import com.fiap.tc.restaurantes.domain.useCase.avaliacao.DeletarAvaliacaoUseCase;
import com.fiap.tc.restaurantes.utils.avaliacao.AvaliacaoHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class DeletarAvaliacaoIT {

    @Autowired
    private DeletarAvaliacaoUseCase deletarAvaliacaoUseCase;

    @Test
    void devePermitirDeletarAvaliacao() {
        var id = 1L;

        var avaliacaoRemovida = deletarAvaliacaoUseCase.execute(id);

        assertThat(avaliacaoRemovida).isTrue();
    }

    @Test
    void deveGerarExcecao_QuandoDeletarAvaliacao_IdNaoEncontrado() {
        var id = 123465L;

        assertThatThrownBy(() -> deletarAvaliacaoUseCase.execute(id))
                .isInstanceOf(AvaliacaoNotFoundException.class)
                .hasMessage("Avaliação de id: " + id + " não encontrada.");
    }
}
