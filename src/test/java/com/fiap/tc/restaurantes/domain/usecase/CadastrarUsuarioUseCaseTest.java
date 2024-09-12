package com.fiap.tc.restaurantes.domain.usecase;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.gateway.usuario.CadastrarUsuarioInterface;
import com.fiap.tc.restaurantes.domain.usecase.usuario.CadastrarUsuarioUseCase;
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
public class CadastrarUsuarioUseCaseTest {
  private CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

  @Mock
  private CadastrarUsuarioInterface cadastrarUsuarioInterface;

  @BeforeEach
  public void setUp() {
    cadastrarUsuarioUseCase = new CadastrarUsuarioUseCase(cadastrarUsuarioInterface);
  }

  @Test
  void deveCadastrarUsuario() {
    // Arrange
    Usuario usuario = UsuarioHelper.gerarUsuarioValido();

    when(cadastrarUsuarioUseCase.cadastrarUsuario(any(Usuario.class))).thenReturn(usuario);

    // Act
    Usuario usuarioCadastrado = cadastrarUsuarioUseCase.cadastrarUsuario(usuario);

    // Assert
    assertThat(usuarioCadastrado)
        .isNotNull()
        .isInstanceOf(Usuario.class);

    assertThat(usuarioCadastrado.getNome())
        .isEqualTo(usuario.getNome());
    assertThat(usuarioCadastrado.getEmail())
        .isEqualTo(usuario.getEmail());
    assertThat(usuarioCadastrado.getSenha())
        .isEqualTo(usuario.getSenha());
    assertThat(usuarioCadastrado.getTelefone())
        .isEqualTo(usuario.getTelefone());
  }
}
