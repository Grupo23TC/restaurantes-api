package com.fiap.tc.restaurantes.infra.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.fail;

public class AvaliacaoRepositoryTest {

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

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
