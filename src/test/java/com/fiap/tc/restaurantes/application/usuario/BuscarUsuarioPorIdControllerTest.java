package com.fiap.tc.restaurantes.application.usuario;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.mapper.usuario.UsuarioMapper;
import com.fiap.tc.restaurantes.domain.output.usuario.UsuarioResponse;
import com.fiap.tc.restaurantes.domain.usecase.usuario.BuscarUsuarioPorIdUseCase;
import com.fiap.tc.restaurantes.utils.usuario.UsuarioHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BuscarUsuarioPorIdControllerTest {
  @Mock
  private BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;

  @Mock
  private UsuarioMapper usuarioMapper;

  private MockMvc mockMvc;

  private AutoCloseable mock;

  @BeforeEach
  void setUp() {
    mock = MockitoAnnotations.openMocks(this);
    BuscarUsuarioPorIdController controller = new BuscarUsuarioPorIdController(usuarioMapper, buscarUsuarioPorIdUseCase);
    mockMvc = MockMvcBuilders.standaloneSetup(controller)
        .addFilter((request, response, chain) -> {
          response.setCharacterEncoding("UTF-8");
          chain.doFilter(request, response);
        })
        .build();
  }

  @AfterEach
  void tearDown() throws Exception {
    mock.close();
  }

  @Test
  void deveBuscarUsuarioPorId() throws Exception {
    // Arrange
    Long id = 1L;
    Usuario usuario = UsuarioHelper.gerarUsuarioValidoComId();
    UsuarioResponse usuarioResponse = UsuarioHelper.gerarUsuarioResponse();

    when(buscarUsuarioPorIdUseCase.buscarUsuarioPorId(any(Long.class))).thenReturn(usuario);
    when(usuarioMapper.toUsuarioResponse(usuario)).thenReturn(usuarioResponse);

    // Act & Arrange
    mockMvc.perform(get("/usuarios/{id}", id)
        .content(asJsonString(usuarioResponse))
        .contentType(MediaType.APPLICATION_JSON)
    )
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.usuarioId").value(id))
        .andExpect(jsonPath("$.nome").value(usuarioResponse.nome()))
        .andExpect(jsonPath("$.email").value(usuarioResponse.email()))
        .andExpect(jsonPath("$.telefone").value(usuarioResponse.telefone()))
        .andExpect(jsonPath("$.senha").value(usuarioResponse.senha()));

  }

  private String asJsonString(final Object object) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    return mapper.writeValueAsString(object);
  }
}
