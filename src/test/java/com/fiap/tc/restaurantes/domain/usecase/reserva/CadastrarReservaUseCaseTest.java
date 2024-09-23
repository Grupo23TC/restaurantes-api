package com.fiap.tc.restaurantes.domain.usecase.reserva;

import com.fiap.tc.restaurantes.domain.gateway.reserva.CadastrarReservaInterface;
import com.fiap.tc.restaurantes.domain.usecase.avaliacao.CadastrarAvaliacaoUseCase;
import com.fiap.tc.restaurantes.domain.usecase.mesa.BuscarMesaPorIdUseCase;
import com.fiap.tc.restaurantes.domain.usecase.usuario.BuscarUsuarioPorIdUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.fail;

class CadastrarReservaUseCaseTest {

    private CadastrarReservaUseCase cadastrarReservaUseCase;

    @Mock
    private CadastrarReservaInterface cadastrarReservaInterface;

    @Mock
    private BuscarUsuarioPorIdUseCase buscarUsuarioPorIdUseCase;

    @Mock
    private BuscarMesaPorIdUseCase buscarMesaPorIdUseCase;

    @Mock
    private BuscarReservasPorMesaEPeriodoUseCase buscarReservasPorMesaEPeriodoUseCase;

    AutoCloseable mock;

    @BeforeEach
    public void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        cadastrarReservaUseCase = new CadastrarReservaUseCase(cadastrarReservaInterface,
                buscarUsuarioPorIdUseCase,
                buscarMesaPorIdUseCase,
                buscarReservasPorMesaEPeriodoUseCase);
    }

    @AfterEach
    public void tearDown() throws Exception {
        mock.close();
    }

    @Test
    void devePermitirCadastrarReserva() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarReserva_IdNaoEncontrado() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarReserva_DataInicioAntesDeHoje() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarReserva_DataFimAntesDeHoje() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarReserva_DataInicioMaiorQueDataFim() {
        fail("não implementado");
    }

    @Test
    void deveGerarExcecao_QuandoCadastrarReserva_MesaJaReservada() {
        fail("não implementado");
    }
}
