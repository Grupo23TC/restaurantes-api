package com.fiap.tc.restaurantes.domain.useCase.avaliacao.integracao;

import com.fiap.tc.restaurantes.domain.useCase.avaliacao.CadastrarAvaliacaoUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.fail;
@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class CadastrarAvaliacaoIT {

    @Autowired
    private CadastrarAvaliacaoUseCase cadastrarAvaliacaoUseCase;

    @Test
    void devePermitirCadastrarAvaliacao() {
        fail("Não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarAvaliacao_RestauranteNaoEncontrado() {
        fail("Não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarAvaliacao_UsuarioNaoEncontrado() {
        fail("Não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarAvaliacao_NotaInvalida() {
        fail("Não implementado");
    }
}
