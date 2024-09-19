package com.fiap.tc.restaurantes.application.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.CadastrarRestauranteInterface;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.ConsultarEnderecoPorCepInterface;
import com.fiap.tc.restaurantes.domain.usecase.restaurante.CadastrarRestauranteUseCase;
import com.fiap.tc.restaurantes.infra.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.infra.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.utils.restaurante.RestauranteHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CadastrarRestauranteUseCaseTest {

    @Mock
    private RestauranteRepository repository;

    private CadastrarRestauranteUseCase useCase;

    @Mock
    private CadastrarRestauranteInterface cadastrarRestauranteInterface;

    @Mock
    private ConsultarEnderecoPorCepInterface consultarEnderecoPorCepInterface;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        useCase = new CadastrarRestauranteUseCase(cadastrarRestauranteInterface, consultarEnderecoPorCepInterface);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void devePermitirCadastrarRestaurante() {
        // Arrange
        Restaurante entidade = RestauranteHelper.gerarRestauranteValido();

        when(repository.save(any(RestauranteEntity.class)))
                .thenAnswer(answer -> answer.getArgument(0));

        when(consultarEnderecoPorCepInterface.consultaPorCep(entidade.getEndereco().getCep())).thenReturn(RestauranteHelper.enderecoBuilder());
        when(cadastrarRestauranteInterface.cadastrarRestaurante(entidade)).thenReturn(entidade);

        // Act
        Restaurante restauranteSalvo = useCase.cadastrarRestaurante(entidade);

        // Assert
        assertThat(restauranteSalvo)
                .isNotNull()
                .isInstanceOf(Restaurante.class)
                .isEqualTo(entidade);

        assertThat(restauranteSalvo.getNome())
                .isEqualTo(entidade.getNome());

        verify(cadastrarRestauranteInterface, times(1)).cadastrarRestaurante(any(Restaurante.class));
    }
}