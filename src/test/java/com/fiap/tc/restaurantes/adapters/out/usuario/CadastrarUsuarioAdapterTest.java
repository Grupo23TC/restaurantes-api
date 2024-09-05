package com.fiap.tc.restaurantes.adapters.out.usuario;

import com.fiap.tc.restaurantes.RestaurantesApplication;
import com.fiap.tc.restaurantes.adapters.out.repository.UsuarioRepository;
import com.fiap.tc.restaurantes.adapters.out.repository.entity.UsuarioEntity;
import com.fiap.tc.restaurantes.adapters.out.repository.mapper.UsuarioEntityMapper;
import com.fiap.tc.restaurantes.application.core.domain.Usuario;
import com.fiap.tc.restaurantes.utils.usuario.UsuarioHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CadastrarUsuarioAdapterTest {
  private CadastrarUsuarioAdapter cadastrarUsuarioAdapter;

  @Mock
  private UsuarioRepository repository;
  @Mock
  private UsuarioEntityMapper entityMapper;

  @BeforeEach
  void setUp() {
    cadastrarUsuarioAdapter = new CadastrarUsuarioAdapter(repository, entityMapper);
  }

  @Test
  void devePermitirCadastrarUsuario() {
    // Arrange
    Usuario usuario = UsuarioHelper.gerarUsuarioValido();
    UsuarioEntity entidade = new UsuarioEntity();
    entidade.setNome(usuario.getNome());
    entidade.setEmail(usuario.getEmail());
    entidade.setSenha(usuario.getSenha());
    entidade.setTelefone(usuario.getTelefone());

    when(entityMapper.toUsuarioEntity(usuario)).thenReturn(entidade);

    when(entityMapper.toUsuario(entidade)).thenReturn(usuario);

    when(repository.save(any(UsuarioEntity.class)))
        .thenAnswer(answer -> answer.getArgument(0));

    // Act
    Usuario usuarioCadastrado = cadastrarUsuarioAdapter.cadastrarUsuario(usuario);

    // Assert
    assertThat(usuarioCadastrado)
        .isNotNull()
        .isInstanceOf(Usuario.class);

    assertThat(usuarioCadastrado.getNome()).isEqualTo(usuario.getNome());
    assertThat(usuarioCadastrado.getEmail()).isEqualTo(usuario.getEmail());
    assertThat(usuarioCadastrado.getSenha()).isEqualTo(usuario.getSenha());
    assertThat(usuarioCadastrado.getTelefone()).isEqualTo(usuario.getTelefone());

    verify(repository, times(1)).save(any(UsuarioEntity.class));
    verify(entityMapper, times(1)).toUsuarioEntity(any(Usuario.class));
    verify(entityMapper, times(1)).toUsuario(any(UsuarioEntity.class));
  }

}
