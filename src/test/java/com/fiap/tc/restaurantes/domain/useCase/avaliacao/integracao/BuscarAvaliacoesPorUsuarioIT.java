package com.fiap.tc.restaurantes.domain.useCase.avaliacao.integracao;

import com.fiap.tc.restaurantes.domain.gateway.avaliacao.BuscarAvaliacoesPorUsuarioInterface;
import com.fiap.tc.restaurantes.domain.useCase.avaliacao.BuscarAvaliacoesPorUsuarioUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.fail;
@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class BuscarAvaliacoesPorUsuarioIT {

    @Autowired
    private BuscarAvaliacoesPorUsuarioUseCase buscarAvaliacoesPorUsuarioUseCase;

    @Mock
    private BuscarAvaliacoesPorUsuarioInterface buscarAvaliacoesPorUsuarioInterface;

    @Test
    void devePermitirBuscarAvaliacoesPorUsuario() {
        fail("Não implementado");
    }
}
