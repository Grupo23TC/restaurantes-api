package com.fiap.tc.restaurantes.domain.usecase.usuario;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.exception.usuario.UsuarioNotFoundException;
import com.fiap.tc.restaurantes.domain.gateway.usuario.DeletarUsuarioInterface;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.BuscarAvaliacoesPorUsuarioUseCase;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.DeletarAvaliacaoUseCase;
import com.fiap.tc.restaurantes.utils.avaliacao.AvaliacaoHelper;
import com.fiap.tc.restaurantes.utils.usuario.UsuarioHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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
  @Mock
  private BuscarAvaliacoesPorUsuarioUseCase buscarAvaliacoesPorUsuarioUseCase;
  @Mock
  private DeletarAvaliacaoUseCase deletarAvaliacaoUseCase;

  @BeforeEach
  public void setUp() {
    this.deletarUsuarioUseCase = new DeletarUsuarioUseCase(
        deletarUsuarioInterface,
        buscarUsuarioPorIdUseCase,
        buscarAvaliacoesPorUsuarioUseCase,
        deletarAvaliacaoUseCase
    );
  }

  @Test
  void deveDeletarUsuario_ComAvaliacao() {
    Avaliacao avaliacao1 = AvaliacaoHelper.gerarAvaliacao();
    Avaliacao avaliacao2 = AvaliacaoHelper.gerarAvaliacao();
    Avaliacao avaliacao3 = AvaliacaoHelper.gerarAvaliacao();
    avaliacao1.setAvaliacaoId(1L);
    avaliacao2.setAvaliacaoId(2L);
    avaliacao3.setAvaliacaoId(3L);
    List<Avaliacao> avaliacoes = List.of(avaliacao1, avaliacao2, avaliacao3);
    Long id = 1L;
    Usuario usuarioBuscado = UsuarioHelper.gerarUsuarioValido();
    usuarioBuscado.setUsuarioId(id);

    when(buscarUsuarioPorIdUseCase.buscarUsuarioPorId(any(Long.class))).thenReturn(usuarioBuscado);
    when(deletarUsuarioInterface.deletarUsuario(any(Long.class))).thenReturn(true);
    when(buscarAvaliacoesPorUsuarioUseCase.buscarAvaliacoesPorUsuario(any(Long.class))).thenReturn(avaliacoes);
    when(deletarAvaliacaoUseCase.deletarAvaliacao(any(Long.class))).thenReturn(true);

    //Act
    boolean usuarioDeletado = deletarUsuarioUseCase.deletarUsuario(id);

    // Assert
    assertThat(usuarioDeletado).isTrue();

    verify(buscarUsuarioPorIdUseCase, times(1)).buscarUsuarioPorId(any(Long.class));
    verify(deletarUsuarioInterface, times(1)).deletarUsuario(any(Long.class));
    verify(buscarAvaliacoesPorUsuarioUseCase, times(1)).buscarAvaliacoesPorUsuario(any(Long.class));
    verify(deletarAvaliacaoUseCase, times(3)).deletarAvaliacao(any(Long.class));
  }

  @Test
  void deveDeletarUsuario_SemAvaliacao() {
    // Arrange
    List<Avaliacao> avaliacoes = List.of();
    Long id = 1L;
    Usuario usuarioBuscado = UsuarioHelper.gerarUsuarioValido();
    usuarioBuscado.setUsuarioId(id);

    when(buscarUsuarioPorIdUseCase.buscarUsuarioPorId(any(Long.class))).thenReturn(usuarioBuscado);
    when(deletarUsuarioInterface.deletarUsuario(any(Long.class))).thenReturn(true);
    when(buscarAvaliacoesPorUsuarioUseCase.buscarAvaliacoesPorUsuario(any(Long.class))).thenReturn(avaliacoes);

    //Act
    boolean usuarioDeletado = deletarUsuarioUseCase.deletarUsuario(id);

    // Assert
    assertThat(usuarioDeletado).isTrue();

    verify(buscarUsuarioPorIdUseCase, times(1)).buscarUsuarioPorId(any(Long.class));
    verify(deletarUsuarioInterface, times(1)).deletarUsuario(any(Long.class));
    verify(buscarAvaliacoesPorUsuarioUseCase, times(1)).buscarAvaliacoesPorUsuario(any(Long.class));
    verify(deletarAvaliacaoUseCase, never()).deletarAvaliacao(any(Long.class));
  }

  @Test
  void deveGerarExcecao_QuandoExcluirUsuario_IdDoUsuarioNaoExiste() {
    // Arrange
    Long id = 2L;

    when(buscarUsuarioPorIdUseCase.buscarUsuarioPorId(any(Long.class)))
        .thenThrow(new UsuarioNotFoundException("Usuário de id: " + id + " não encontrado."));

    // Act && Assert
    assertThatThrownBy(() -> deletarUsuarioUseCase.deletarUsuario(id))
        .isInstanceOf(UsuarioNotFoundException.class)
        .hasMessage("Usuário de id: " + id + " não encontrado.");

    verify(buscarUsuarioPorIdUseCase, times(1)).buscarUsuarioPorId(any(Long.class));
    verify(buscarAvaliacoesPorUsuarioUseCase, never()).buscarAvaliacoesPorUsuario(any(Long.class));
    verify(deletarAvaliacaoUseCase, never()).deletarAvaliacao(any(Long.class));
    verify(deletarUsuarioInterface, never()).deletarUsuario(any(Long.class));
  }
}
