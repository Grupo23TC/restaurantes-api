package com.fiap.tc.restaurantes.domain.useCase.avaliacao.integracao;

import com.fiap.tc.restaurantes.domain.useCase.avaliacao.DeletarAvaliacaoUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class DeletarAvaliacaoIT {

    @Autowired
    private DeletarAvaliacaoUseCase deletarAvaliacaoUseCase;

    @Test
    void devePermitirDeletarAvaliacao() {
        fail("Não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoDeletarAvaliacao_IdNaoEncontrado() {
        fail("Não implementado");
    }
}
