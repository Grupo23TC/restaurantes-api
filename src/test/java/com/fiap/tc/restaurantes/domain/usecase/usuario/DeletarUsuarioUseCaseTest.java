package com.fiap.tc.restaurantes.domain.usecase.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.exception.usuario.UsuarioNotFoundException;
import com.fiap.tc.restaurantes.domain.gateway.usuario.DeletarUsuarioInterface;
import com.fiap.tc.restaurantes.utils.usuario.UsuarioHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeletarUsuarioUseCaseTest {
  private DeletarUsuarioUseCase deletarUsuarioUseCase;

  @Mock
  private DeletarUsuarioInterface deletarUsuarioInterface;
  @Mock
  private BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;

  @BeforeEach
  public void setUp() {
    this.deletarUsuarioUseCase = new DeletarUsuarioUseCase(deletarUsuarioInterface, buscarUsuarioPorIdUseCase);
  }

  @Test
  void deveDeletarUsuario() {
    // Arrange
    Long id = 1L;
    Usuario usuarioBuscado = UsuarioHelper.gerarUsuarioValido();
    usuarioBuscado.setUsuarioId(id);

    doReturn(usuarioBuscado).when(buscarUsuarioPorIdUseCase)
        .buscarUsuarioPorId(any(Long.class));
    when(deletarUsuarioInterface.deletarUsuario(any(Long.class))).thenReturn(true);

    //Act
    boolean usuarioDeletado = deletarUsuarioUseCase.deletarUsuario(id);

    // Assert
    assertThat(usuarioDeletado).isTrue();

    verify(buscarUsuarioPorIdUseCase, times(1)).buscarUsuarioPorId(any(Long.class));
    verify(deletarUsuarioInterface, times(1)).deletarUsuario(any(Long.class));
  }

  @Test
  void deveGerarExcecao_QuandoExcluirUsuario_IdDoUsuarioNaoExiste() {
    // Arrange
    Long id = 2L;

    when(buscarUsuarioPorIdUseCase.buscarUsuarioPorId(any(Long.class)))
        .thenThrow(new UsuarioNotFoundException("Id do usuário não encontrado"));

    // Act && Assert
    assertThatThrownBy(() -> deletarUsuarioUseCase.deletarUsuario(id))
        .isInstanceOf(UsuarioNotFoundException.class)
        .hasMessage("Id do usuário não encontrado");

    verify(buscarUsuarioPorIdUseCase, times(1)).buscarUsuarioPorId(any(Long.class));
    verify(deletarUsuarioInterface, never()).deletarUsuario(any(Long.class));
  }
}
