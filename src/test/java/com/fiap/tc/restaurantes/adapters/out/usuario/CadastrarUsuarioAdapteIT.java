package com.fiap.tc.restaurantes.adapters.out.usuario;

import com.fiap.tc.restaurantes.adapters.out.repository.UsuarioRepository;
import com.fiap.tc.restaurantes.adapters.out.repository.entity.UsuarioEntity;
import com.fiap.tc.restaurantes.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.fiap.tc.restaurantes.application.core.domain.Usuario;
import com.fiap.tc.restaurantes.utils.usuario.UsuarioHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CadastrarUsuarioAdapteIT {
  private CadastrarUsuarioAdapter cadastrarUsuarioAdapter;
  private UsuarioRepository usuarioRepository;
  private UsuarioEntityMapper mapper;

  @BeforeEach
  public void setUp() {
    cadastrarUsuarioAdapter = new CadastrarUsuarioAdapter(usuarioRepository, mapper);
  }

  @Test
  void devePermitirCadastroUsuario() {
    // Arrange
    Usuario usuario = UsuarioHelper.gerarUsuarioValido();

    // Act
    Usuario usuarioCadastrado = cadastrarUsuarioAdapter.cadastrarUsuario(usuario);

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
