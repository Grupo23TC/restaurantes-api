package com.fiap.tc.restaurantes.domain.usecase.usuario.integracao;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.exception.usuario.UsuarioNotFoundException;
import com.fiap.tc.restaurantes.domain.usecase.usuario.BuscarUsuarioPorIdUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BuscarUsuarioPorIdUseCaseIT {
  @Autowired
  private BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;

  @Test
  void deveBuscarUsuarioPorIdUseCase() {
    // Arrange
    Long id = 1L;

    // Act
    Usuario usuario = buscarUsuarioPorIdUseCase.buscarUsuarioPorId(id);

    // Assert
    assertThat(usuario)
        .isNotNull()
        .isInstanceOf(Usuario.class);

    assertThat(usuario.getUsuarioId())
        .isNotNull()
        .isEqualTo(id);

    assertThat(usuario.getNome())
        .isNotEmpty()
        .isEqualTo("Lucas Franco");

    assertThat(usuario.getEmail())
        .isNotEmpty()
        .isEqualTo("lucas.franco@email.com");

    assertThat(usuario.getSenha())
        .isNotEmpty()
        .isEqualTo("Senha@12");

    assertThat(usuario.getTelefone())
        .isNotEmpty()
        .isEqualTo("11999999901");
  }

  @Test
  void deveGerarExcecao_QuandoBuscarUsuarioPorId_IdNaoExiste() {
    // Arrange
    Long id = 100L;

    // Act & Assert
    assertThatThrownBy(() -> buscarUsuarioPorIdUseCase.buscarUsuarioPorId(id))
        .isInstanceOf(UsuarioNotFoundException.class)
        .hasMessage("Id do usuário não encontrado");
  }
}
