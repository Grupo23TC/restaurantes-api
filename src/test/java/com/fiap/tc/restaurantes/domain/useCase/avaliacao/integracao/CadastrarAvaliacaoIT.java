package com.fiap.tc.restaurantes.domain.useCase.avaliacao.integracao;

import com.fiap.tc.restaurantes.domain.entity.Avaliacao;
import com.fiap.tc.restaurantes.domain.exception.restaurante.RestauranteNotFoundException;
import com.fiap.tc.restaurantes.domain.exception.usuario.UsuarioNotFoundException;
import com.fiap.tc.restaurantes.domain.useCase.avaliacao.CadastrarAvaliacaoUseCase;
import com.fiap.tc.restaurantes.utils.avaliacao.AvaliacaoHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class CadastrarAvaliacaoIT {

    @Autowired
    private CadastrarAvaliacaoUseCase cadastrarAvaliacaoUseCase;

    @Test
    void devePermitirCadastrarAvaliacao() {
        var avaliacao = AvaliacaoHelper.gerarAvaliacao();

        var avaliacaoArmazenada = cadastrarAvaliacaoUseCase.execute(avaliacao);

        assertThat(avaliacaoArmazenada)
                .isNotNull()
                .isInstanceOf(Avaliacao.class);
        assertThat(avaliacaoArmazenada.getAvaliacaoId()).isPositive();
        assertThat(avaliacaoArmazenada.getDataAvaliacao()).isEqualTo(avaliacao.getDataAvaliacao());
        assertThat(avaliacaoArmazenada.getNota()).isEqualTo(avaliacao.getNota());
        assertThat(avaliacaoArmazenada.getComentario()).isEqualTo(avaliacao.getComentario());
        assertThat(avaliacaoArmazenada.getUsuario().getUsuarioId()).isEqualTo(avaliacao.getUsuario().getUsuarioId());
        assertThat(avaliacaoArmazenada.getRestaurante().getRestauranteId()).isEqualTo(avaliacao.getRestaurante().getRestauranteId());
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarAvaliacao_RestauranteNaoEncontrado() {
        var avaliacao = AvaliacaoHelper.gerarAvaliacao();
        var restauranteId = 123456798L;
        avaliacao.getRestaurante().setRestauranteId(restauranteId);

        assertThatThrownBy(() -> cadastrarAvaliacaoUseCase.execute(avaliacao))
                .isInstanceOf(RestauranteNotFoundException.class)
                .hasMessage("Restaurante de id: " + restauranteId + " não encontrado.");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarAvaliacao_UsuarioNaoEncontrado() {
        var avaliacao = AvaliacaoHelper.gerarAvaliacao();
        var usuarioId = 123456798L;
        avaliacao.getUsuario().setUsuarioId(usuarioId);

        assertThatThrownBy(() -> cadastrarAvaliacaoUseCase.execute(avaliacao))
                .isInstanceOf(UsuarioNotFoundException.class)
                .hasMessage("Usuário de id: " + usuarioId + " não encontrado.");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarAvaliacao_NotaInvalida() {
        var avaliacao = AvaliacaoHelper.gerarAvaliacao();
        avaliacao.setNota(30);

        assertThatThrownBy(() -> cadastrarAvaliacaoUseCase.execute(avaliacao))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("A Nota deve ser entre 0 e 5");
    }
}
