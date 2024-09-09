package com.fiap.tc.restaurantes.infra.repository.integracao;

import com.fiap.tc.restaurantes.infra.repository.AvaliacaoRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class AvaliacaoRepositoryIT {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Nested
    class CadastrarAvaliacao {

        @Test
        void devePermitirCadastrarAvaliacao() {
            fail("Não implementado");
        }

    }

    @Nested
    class BuscarAvaliacao {

        @Test
        void devePermitirBuscarAvaliacaoPorId() {
            fail("Não implementado");
        }

        @Test
        void devePermitirBuscarAvaliacaoPorRestaurante() {
            fail("Não implementado");
        }

        @Test
        void devePermitirBuscarAvaliacaoPorUsuario() {
            fail("Não implementado");
        }

    }

    @Nested
    class DeletarAvaliacao {

        @Test
        void devePermitirDeletarAvaliacao() {
            fail("Não implementado");
        }

    }

}
