package com.fiap.tc.restaurantes.domain.usecase.avaliacao.integracao;

import com.fiap.tc.restaurantes.domain.usecase.avaliacao.BuscarAvaliacoesPorUsuarioUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class BuscarAvaliacoesPorUsuarioIT {

    @Autowired
    private BuscarAvaliacoesPorUsuarioUseCase buscarAvaliacoesPorUsuarioUseCase;

    @Test
    void devePermitirBuscarAvaliacoesPorUsuario() {
        var usuarioId = 1L;

        var listAvaliacoes = buscarAvaliacoesPorUsuarioUseCase.execute(usuarioId);

        assertThat(listAvaliacoes)
                .isNotEmpty()
                .hasSize(2);
    }
}
