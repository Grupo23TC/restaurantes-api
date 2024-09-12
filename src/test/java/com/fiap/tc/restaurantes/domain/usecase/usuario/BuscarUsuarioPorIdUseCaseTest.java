package com.fiap.tc.restaurantes.domain.usecase.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.gateway.usuario.BuscarUsuarioPorIdInterface;
import com.fiap.tc.restaurantes.utils.usuario.UsuarioHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscarUsuarioPorIdUseCaseTest {
  private BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;

  @Mock
  private BuscarUsuarioPorIdInterface buscarUsuarioPorIdInterface;

  @BeforeEach
  public void setUp() {
    this.buscarUsuarioPorIdUseCase = new BuscarUsuarioPorIdUseCase(buscarUsuarioPorIdInterface);
  }

  @Test
  void deveBuscarUsuarioPorId() {
    // Arrange
    Usuario usuario = UsuarioHelper.gerarUsuarioValido();
    Long id = 1L;
    usuario.setUsuarioId(id);

    when(buscarUsuarioPorIdInterface.buscarUsuarioPorId(id)).thenReturn(usuario);

    // Act
    Usuario usuarioBuscado = buscarUsuarioPorIdUseCase.buscarUsuarioPorId(id);

    // Assert
    assertThat(usuarioBuscado)
        .isNotNull()
        .isInstanceOf(Usuario.class)
        .isEqualTo(usuario);
  }
}
