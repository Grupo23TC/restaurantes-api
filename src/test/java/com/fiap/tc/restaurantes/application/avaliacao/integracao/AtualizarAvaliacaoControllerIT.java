package com.fiap.tc.restaurantes.application.avaliacao.integracao;

import com.fiap.tc.restaurantes.application.avaliacao.AtualizarAvaliacaoController;
import com.fiap.tc.restaurantes.domain.mapper.avaliacao.AvaliacaoMapper;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.AtualizarAvaliacaoUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.fail;

class AtualizarAvaliacaoControllerIT {

    @Mock
    private AtualizarAvaliacaoUseCase atualizarAvaliacaoUseCase;

    @Mock
    private AvaliacaoMapper mapper;

    private MockMvc mockMvc;

    AutoCloseable mock;

    @BeforeEach
    public void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        AtualizarAvaliacaoController controller = new AtualizarAvaliacaoController(mapper, atualizarAvaliacaoUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void devePermitirAtualizarAvaliacao() {
        fail("Não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoAtualizarAvaliacao_IdNaoEncontrado() {
        fail("Não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoAtualizarAvaliacao_NotaInvalida() {
        fail("Não implementado");
    }

}
