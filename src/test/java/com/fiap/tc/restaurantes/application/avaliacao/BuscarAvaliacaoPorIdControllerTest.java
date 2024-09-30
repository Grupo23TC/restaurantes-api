package com.fiap.tc.restaurantes.application.avaliacao;

import com.fiap.tc.restaurantes.application.handler.GlobalExceptionHandler;
import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.exception.avaliacao.AvaliacaoNotFoundException;
import com.fiap.tc.restaurantes.domain.mapper.avaliacao.AvaliacaoMapper;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.BuscarAvaliacaoPorIdUseCase;
import com.fiap.tc.restaurantes.utils.avaliacao.AvaliacaoHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BuscarAvaliacaoPorIdControllerTest {

    @Mock
    private BuscarAvaliacaoPorIdUseCase buscarAvaliacaoPorIdUseCase;

    @Mock
    private AvaliacaoMapper mapper;

    private MockMvc mockMvc;

    AutoCloseable mock;

    @BeforeEach
    public void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        BuscarAvaliacaoPorIdController controller = new BuscarAvaliacaoPorIdController(mapper, buscarAvaliacaoPorIdUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandler())
                .addFilter((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                }).build();
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void devePermitirBuscarAvaliacaoPorId() throws Exception {
        Long id = 1L;
        var avaliacao = AvaliacaoHelper.gerarAvaliacao();
        var avaliacaoResponse = AvaliacaoHelper.gerarAvaliacaoResponse();
        when(buscarAvaliacaoPorIdUseCase.buscarAvaliacaoPorId(anyLong())).thenReturn(avaliacao);
        when(mapper.toAvaliacaoResponse(any(Avaliacao.class))).thenReturn(avaliacaoResponse);

        mockMvc.perform(get("/avaliacoes/{id}", id))
                
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.avaliacaoId").value(id))
                .andExpect(jsonPath("$.usuarioId").value(avaliacaoResponse.usuarioId()))
                .andExpect(jsonPath("$.restauranteId").value(avaliacaoResponse.restauranteId()))
                .andExpect(jsonPath("$.nota").value(avaliacaoResponse.nota()))
                .andExpect(jsonPath("$.comentario").value(avaliacaoResponse.comentario()));

        verify(buscarAvaliacaoPorIdUseCase, times(1)).buscarAvaliacaoPorId(anyLong());
        verify(mapper, times(1)).toAvaliacaoResponse(any(Avaliacao.class));
    }

    @Test
    void deveGerarExcecao_QuandoBuscarAvaliacaoPorId_IdNaoEncontrado() throws Exception {
        Long id = 1L;
        var avaliacaoResponse = AvaliacaoHelper.gerarAvaliacaoResponse();
        var mensagemException = "Avaliação de id: " + id + " não encontrada.";
        when(buscarAvaliacaoPorIdUseCase.buscarAvaliacaoPorId(anyLong()))
                .thenThrow(new AvaliacaoNotFoundException(mensagemException));
        when(mapper.toAvaliacaoResponse(any(Avaliacao.class))).thenReturn(avaliacaoResponse);

        mockMvc.perform(get("/avaliacoes/{id}", id))
                
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.erro").value(mensagemException))
                .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.horario").exists())
                .andExpect(jsonPath("$.rota").value("/avaliacoes/" + id));
        verify(buscarAvaliacaoPorIdUseCase, times(1)).buscarAvaliacaoPorId(anyLong());
        verify(mapper, never()).toAvaliacaoResponse(any(Avaliacao.class));
    }
}
