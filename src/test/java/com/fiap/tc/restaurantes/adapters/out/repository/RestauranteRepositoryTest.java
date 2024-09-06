package com.fiap.tc.restaurantes.adapters.out.repository;

import com.fiap.tc.restaurantes.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.utils.restaurante.RestauranteHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RestauranteRepositoryTest {

    @Mock
    public RestauranteRepository repository;

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
    class CadastraRestaurante {

        @Test
        void devePermitirCadastrarRestauranteEntity() {
            // Arrange
            RestauranteEntity entidade = RestauranteHelper.gerarRestauranteValido();

            when(repository.save(any(RestauranteEntity.class)))
                    .thenAnswer(answer -> answer.getArgument(0));


            // Act
            RestauranteEntity restauranteSalvo = repository.save(entidade);

            // Assert
            assertThat(restauranteSalvo)
                    .isNotNull()
                    .isInstanceOf(RestauranteEntity.class)
                    .isEqualTo(entidade);

            assertThat(restauranteSalvo.getNome())
                    .isEqualTo(entidade.getNome());

            verify(repository, times(1)).save(any(RestauranteEntity.class));
        }
    }

    @Nested
    class BuscarRestaurante {

        @Test
        void devePermitirBuscarRestauranteEntityPorId() {
            // Arrange
            Long id = 1L;

            RestauranteEntity entidade = RestauranteHelper.gerarRestauranteValido();
            entidade.setRestauranteId(id);

            when(repository.findById(id))
                    .thenReturn(Optional.of(entidade));

            // Act
            Optional<RestauranteEntity> restauranteEntityOptional = repository.findById(id);

            // Assert
            assertThat(restauranteEntityOptional)
                    .isPresent()
                    .containsSame(entidade);

            restauranteEntityOptional.ifPresent(restauranteEntity -> {
                assertThat(restauranteEntity.getRestauranteId())
                        .isPositive();

                assertThat(restauranteEntity.getNome())
                        .isEqualTo(entidade.getNome());
            });

            verify(repository, times(1)).findById(any(Long.class));
        }
    }

    @Nested
    class DeletarRestaurante {
        @Test
        void devePermitirDeletarRestauranteEntity() {
            // Arrange
            Long id = 1L;

            doNothing().when(repository).deleteById(any(Long.class));

            // Act
            repository.deleteById(id);

            // Assert
            verify(repository, times(1)).deleteById(any(Long.class));
        }
    }

    @Nested
    class ListarUsuario {
        @Test
        void devePermitirListarRestauranteEntity() {
            // Arrange
            RestauranteEntity entidade1 = RestauranteHelper.gerarRestauranteValido();
            RestauranteEntity entidade2 = RestauranteHelper.gerarRestauranteValido();

            List<RestauranteEntity> restauranteEntities = Arrays.asList(entidade1, entidade2);

            when(repository.findAll())
                    .thenReturn(restauranteEntities);

            // Act
            List<RestauranteEntity> restauranteEntityList = repository.findAll();

            // Assert
            assertThat(restauranteEntityList)
                    .hasSize(2)
                    .containsExactlyInAnyOrder(entidade1, entidade2);

            verify(repository, times(1)).findAll();
        }
    }

    @Test
    void findByNomeContaining() {
        // Arrange
        RestauranteEntity entidade1 = RestauranteHelper.gerarRestauranteValido();
        RestauranteEntity entidade2 = RestauranteHelper.gerarRestauranteValido();

        String nome = "Nome Teste";

        List<RestauranteEntity> restauranteEntities = Arrays.asList(entidade1, entidade2);

        when(repository.findByNomeContaining(any()))
                .thenReturn(restauranteEntities);

        List<RestauranteEntity> restauranteEntityList = repository.findByNomeContaining(nome);

        // Assert
        assertThat(restauranteEntityList)
                .hasSize(2)
                .containsExactlyInAnyOrder(entidade1, entidade2);

        assertThat(restauranteEntityList.get(0).getNome())
                .isEqualTo(entidade1.getNome());

        assertThat(restauranteEntityList.get(1).getNome())
                .isEqualTo(entidade1.getNome());

        verify(repository, times(1)).findByNomeContaining(any());
    }

    @Test
    void findByTipoDeCozinha() {
        // Arrange
        RestauranteEntity entidade1 = RestauranteHelper.gerarRestauranteValido();
        RestauranteEntity entidade2 = RestauranteHelper.gerarRestauranteValido();

        String tipoCozinha = "MEXICANA";

        List<RestauranteEntity> restauranteEntities = Arrays.asList(entidade1, entidade2);

        when(repository.findByTipoDeCozinha(any()))
                .thenReturn(restauranteEntities);

        List<RestauranteEntity> restauranteEntityList = repository.findByTipoDeCozinha(tipoCozinha);

        // Assert
        assertThat(restauranteEntityList)
                .hasSize(2)
                .containsExactlyInAnyOrder(entidade1, entidade2);

        assertThat(restauranteEntityList.get(0).getTipoDeCozinha())
                .isEqualTo(entidade1.getTipoDeCozinha());

        assertThat(restauranteEntityList.get(1).getTipoDeCozinha())
                .isEqualTo(entidade1.getTipoDeCozinha());

        verify(repository, times(1)).findByTipoDeCozinha(any());
    }

    @Test
    void findByLocalidade() {
        // Arrange
        RestauranteEntity entidade1 = RestauranteHelper.gerarRestauranteValido();
        RestauranteEntity entidade2 = RestauranteHelper.gerarRestauranteValido();

        String localidade = "Rua Teste";

        List<RestauranteEntity> restauranteEntities = Arrays.asList(entidade1, entidade2);

        when(repository.findByLocalidade(any()))
                .thenReturn(restauranteEntities);

        List<RestauranteEntity> restauranteEntityList = repository.findByLocalidade(localidade);

        // Assert
        assertThat(restauranteEntityList)
                .hasSize(2)
                .containsExactlyInAnyOrder(entidade1, entidade2);

        assertThat(restauranteEntityList.get(0).getEndereco().getRua())
                .isEqualTo(entidade1.getEndereco().getRua());

        assertThat(restauranteEntityList.get(1).getEndereco().getRua())
                .isEqualTo(entidade1.getEndereco().getRua());

        verify(repository, times(1)).findByLocalidade(any());
    }
}