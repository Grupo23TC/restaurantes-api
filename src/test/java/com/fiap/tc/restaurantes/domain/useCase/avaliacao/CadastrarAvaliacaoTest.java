package com.fiap.tc.restaurantes.domain.useCase.avaliacao;

import com.fiap.tc.restaurantes.domain.gateway.avaliacao.CadastrarAvaliacaoInterface;
import com.fiap.tc.restaurantes.domain.useCase.restaurante.BuscarRestaurantePorIdUseCase;
import com.fiap.tc.restaurantes.domain.useCase.usuario.BuscarUsuarioPorIdUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.fail;

public class CadastrarAvaliacaoTest {

    private CadastrarAvaliacaoUseCase cadastrarAvaliacaoUseCase;

    @Mock
    private CadastrarAvaliacaoInterface cadastrarAvaliacaoInterface;

    @Mock
    private BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;

    @Mock
    private BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase;

    AutoCloseable mock;

    @BeforeEach
    public void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        cadastrarAvaliacaoUseCase = new CadastrarAvaliacaoUseCase(cadastrarAvaliacaoInterface, buscarUsuarioPorIdUseCase, buscarRestaurantePorIdUseCase);
    }

    @AfterEach
    public void tearDown() throws Exception {
        mock.close();
    }

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
