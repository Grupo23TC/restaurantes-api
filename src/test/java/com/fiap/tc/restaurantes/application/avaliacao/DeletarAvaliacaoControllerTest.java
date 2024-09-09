package com.fiap.tc.restaurantes.application.avaliacao;

import com.fiap.tc.restaurantes.domain.useCase.avaliacao.DeletarAvaliacaoUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.fail;

public class DeletarAvaliacaoControllerTest {

    @Mock
    private DeletarAvaliacaoUseCase deletarAvaliacaoUseCase;

    private MockMvc mockMvc;

    AutoCloseable mock;

    @BeforeEach
    public void setUp() throws Exception {
        mock = MockitoAnnotations.openMocks(this);
        DeletarAvaliacaoController controller = new DeletarAvaliacaoController(deletarAvaliacaoUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void devePermitirDeletarAvaliacao() {
        fail("Não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoDeletarAvaliacao_IdNaoEncontrado() {
        fail("Não implementado");
    }
}
