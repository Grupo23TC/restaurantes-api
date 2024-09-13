package com.fiap.tc.restaurantes.application.usuario;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.input.usuario.AtualizarUsuarioRequest;
import com.fiap.tc.restaurantes.domain.mapper.usuario.UsuarioMapper;
import com.fiap.tc.restaurantes.domain.output.usuario.UsuarioResponse;
import com.fiap.tc.restaurantes.domain.usecase.usuario.AtualizarUsuarioUseCase;
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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AtualizarUsuarioControllerTest {
  @Mock
  private AtualizarUsuarioUseCase atualizarUsuarioUseCase;

  @Mock
  private UsuarioMapper usuarioMapper;

  private AutoCloseable mock;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    mock = MockitoAnnotations.openMocks(this);
    AtualizarUsuarioController controller = new AtualizarUsuarioController(usuarioMapper, atualizarUsuarioUseCase);
    mockMvc = MockMvcBuilders.standaloneSetup(controller)
        .addFilter((request, response, chain) -> {
          response.setCharacterEncoding("UTF-8");
          chain.doFilter(request, response);
        })
        .build();
  }

  @AfterEach
  public void tearDown() throws Exception {
    mock.close();
  }

  @Test
  void deveAtualizarUsuario() throws Exception {
    // Arrange
    Long id = 1L;
    Usuario usuario = UsuarioHelper.gerarUsuarioValido();
    usuario.setNome("João");
    usuario.setTelefone("00000000001");
    usuario.setSenha("bB@7aw85");
    UsuarioResponse usuarioResponse = UsuarioHelper.gerarUsuarioResponseAtualizado();

    when(atualizarUsuarioUseCase.atualizarUsuario(any(Long.class), any(Usuario.class))).thenReturn(usuario);
    when(usuarioMapper.toUsuario(any(AtualizarUsuarioRequest.class))).thenReturn(usuario);
    when(usuarioMapper.toUsuarioResponse(any(Usuario.class))).thenReturn(usuarioResponse);

    // Act & Assert
    mockMvc.perform(put("/usuarios/{id}", id)
        .content(asJsonString(usuarioResponse))
        .contentType(MediaType.APPLICATION_JSON)
    )
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.usuarioId").value(id))
        .andExpect(jsonPath("$.nome").value(usuario.getNome()))
        .andExpect(jsonPath("$.telefone").value(usuario.getTelefone()))
        .andExpect(jsonPath("$.senha").value(usuario.getSenha()))
        .andExpect(jsonPath("$.email").value(usuario.getEmail()));

    verify(atualizarUsuarioUseCase, times(1)).atualizarUsuario(any(Long.class), any(Usuario.class));
    verify(usuarioMapper, times(1)).toUsuario(any(AtualizarUsuarioRequest.class));
    verify(usuarioMapper, times(1)).toUsuarioResponse(any(Usuario.class));
  }

  private String asJsonString(final Object object) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    return mapper.writeValueAsString(object);
  }
}
