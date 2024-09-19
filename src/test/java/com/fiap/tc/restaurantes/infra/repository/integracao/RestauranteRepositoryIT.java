package com.fiap.tc.restaurantes.infra.repository.integracao;

import com.fiap.tc.restaurantes.infra.entity.EnderecoEntity;
import com.fiap.tc.restaurantes.infra.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.infra.repository.EnderecoRepository;
import com.fiap.tc.restaurantes.infra.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.utils.restaurante.RestauranteHelper;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RestauranteRepositoryIT {

    @Autowired
    RestauranteRepository repository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Nested
    class CadastrarRestaurante {
        @Test
        void devePermitirCadastrarRestaurante(){
            // Arrange
            RestauranteEntity entidade = RestauranteHelper.gerarRestauranteEntityValido();
            EnderecoEntity endereco = RestauranteHelper.enderecoEntityBuilder();

            // Act
            EnderecoEntity enderecoSalvo = enderecoRepository.save(endereco);
            entidade.setEndereco(enderecoSalvo);

            RestauranteEntity restauranteSalvo = repository.save(entidade);

            // Assert
            assertThat(restauranteSalvo)
                    .isNotNull()
                    .isInstanceOf(RestauranteEntity.class);

            assertThat(restauranteSalvo.getNome())
                    .isEqualTo(entidade.getNome());
        }
    }

    @Nested
    class BuscarRestaurantes{
        @Test
        void devePermitirBuscarRestauranteEntityPorNome() {
            // Arrange
            String nome = "restaurante teste 2";

            // Act
            List<RestauranteEntity> restaurantes = repository.findByNomeContaining(nome);

            // Assert
            assertThat(restaurantes).isNotNull();
            assertThat(nome).isEqualTo(restaurantes.get(0).getNome());
        }
    }

    @Nested
    class DeletarRestaurante{
        @Test
        void devePermitirDeletarRestauranteEntity() {
            // Arrange
            Long id = 3L;

            // Act
            repository.deleteById(id);
            Optional<RestauranteEntity> restauranteExcluido = repository.findById(id);

            assertThat(restauranteExcluido.isPresent()).isFalse();
        }
    }

    @Nested
    class ListarRestaurantes {
        @Test
        void devePermitirListarRestauranteEntity() {
            // Act
            List<RestauranteEntity> restauranteEntityList = repository.findAll();

            // Assert
            assertThat(restauranteEntityList)
                    .hasSizeGreaterThan(2);

        }
    }
}
