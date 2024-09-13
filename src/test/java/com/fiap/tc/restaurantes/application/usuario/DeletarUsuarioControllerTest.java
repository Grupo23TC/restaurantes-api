package com.fiap.tc.restaurantes.application.usuario;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fiap.tc.restaurantes.domain.mapper.usuario.UsuarioMapper;
import com.fiap.tc.restaurantes.domain.output.usuario.UsuarioDeletadoResponse;
import com.fiap.tc.restaurantes.domain.usecase.usuario.DeletarUsuarioUseCase;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DeletarUsuarioControllerTest {
  @Mock
  private DeletarUsuarioUseCase deletarUsuarioUseCase;

  private MockMvc mockMvc;

  private AutoCloseable mock;

  @BeforeEach
  public void setUp() {
    mock = MockitoAnnotations.openMocks(this);
    DeletarUsuarioController controller = new DeletarUsuarioController(deletarUsuarioUseCase);
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
  void deveDeletarUsuario() throws Exception {
    // Arrange
    Long id = 1L;
    UsuarioDeletadoResponse usuarioDeletado = UsuarioHelper.gerarUsuarioDeletadoReponse();

    when(deletarUsuarioUseCase.deletarUsuario(any(Long.class))).thenReturn(true);

    // Act & Assert
    mockMvc.perform(delete("/usuarios/{id}", id)
        .content(asJsonString(usuarioDeletado))
        .contentType(MediaType.APPLICATION_JSON)
    )
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.deletado").value(true));

    verify(deletarUsuarioUseCase, times(1)).deletarUsuario(id);
  }

  private String asJsonString(final Object object) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    return mapper.writeValueAsString(object);
  }
}
