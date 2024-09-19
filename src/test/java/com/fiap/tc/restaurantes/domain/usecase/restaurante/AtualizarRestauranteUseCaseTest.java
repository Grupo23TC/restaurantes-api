package com.fiap.tc.restaurantes.domain.usecase.restaurante;

import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.AtualizarRestauranteInterface;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.ConsultarEnderecoPorCepInterface;
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

class AtualizarRestauranteUseCaseTest {

    @Mock
    private RestauranteRepository repository;

    private AtualizarRestauranteUseCase useCase;

    @Mock
    private AtualizarRestauranteInterface atualizarRestauranteInterface;

    @Mock
    private ConsultarEnderecoPorCepInterface consultarEnderecoPorCepInterface;

    AutoCloseable openMocks;


    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        useCase = new AtualizarRestauranteUseCase(atualizarRestauranteInterface, consultarEnderecoPorCepInterface);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void devePermitirAtualizarRestaurante() {
        // Arrange
        Restaurante entidade = RestauranteHelper.gerarRestauranteValido();
        var identificador = 1L;

        when(repository.save(any(RestauranteEntity.class)))
                .thenAnswer(answer -> answer.getArgument(0));

        when(consultarEnderecoPorCepInterface.consultaPorCep(entidade.getEndereco().getCep())).thenReturn(RestauranteHelper.enderecoBuilder());
        when(atualizarRestauranteInterface.atualizarRestaurante(identificador, entidade)).thenReturn(entidade);

        // Act
        Restaurante restauranteSalvo = useCase.atualizarRestaurante(identificador, entidade);

        // Assert
        assertThat(restauranteSalvo)
                .isNotNull()
                .isInstanceOf(Restaurante.class)
                .isEqualTo(entidade);

        assertThat(restauranteSalvo.getNome())
                .isEqualTo(entidade.getNome());

        verify(atualizarRestauranteInterface, times(1)).atualizarRestaurante(any(), any(Restaurante.class));
    }
}