package com.fiap.tc.restaurantes.application.avaliacao;

import com.fiap.tc.restaurantes.domain.mapper.avaliacao.AvaliacaoMapper;
import com.fiap.tc.restaurantes.domain.useCase.avaliacao.BuscarAvaliacoesPorUsuarioUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.fail;

public class BuscarAvaliacoesPorUsuarioControllerTest {

    @Mock
    private BuscarAvaliacoesPorUsuarioUseCase buscarAvaliacoesPorUsuarioUseCase;

    @Mock
    private AvaliacaoMapper mapper;

    private MockMvc mockMvc;

    AutoCloseable mock;

    @BeforeEach
    public void setUp() throws Exception {
        mock = MockitoAnnotations.openMocks(this);
        BuscarAvaliacoesPorUsuarioController controller = new BuscarAvaliacoesPorUsuarioController(mapper, buscarAvaliacoesPorUsuarioUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void devePermitirBuscarAvaliacoesPorUsuario() {
        fail("Não implementado");
    }
}
