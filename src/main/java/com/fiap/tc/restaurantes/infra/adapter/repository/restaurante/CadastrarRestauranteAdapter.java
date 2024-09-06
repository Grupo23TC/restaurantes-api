package com.fiap.tc.restaurantes.infra.adapter.repository.restaurante;

import com.fiap.tc.restaurantes.infra.repository.EnderecoRepository;
import com.fiap.tc.restaurantes.infra.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.infra.entity.EnderecoEntity;
import com.fiap.tc.restaurantes.infra.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.infra.repository.mapper.EnderecoEntityMapper;
import com.fiap.tc.restaurantes.infra.repository.mapper.RestauranteEntityMapper;
import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.CadastrarRestauranteInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class CadastrarRestauranteAdapter implements CadastrarRestauranteInterface {

    private final RestauranteRepository restauranteRepository;
    private final RestauranteEntityMapper entityMapper;

    // TODO ver em qual camada orquestrar esse insert na table de endereco
    private final EnderecoRepository enderecoRepository;
    private final EnderecoEntityMapper enderecoEntityMapper;

    @Override
    public Restaurante cadastrarRestaurante(Restaurante restaurante) {

        RestauranteEntity restauranteEntity = entityMapper.toRestauranteEntity(restaurante);

        // TODO ver em qual camada orquestrar esse insert na table de endereco
        EnderecoEntity enderecoEntity = enderecoEntityMapper.toEnderecoEntity(restaurante.getEndereco());

        enderecoEntity = enderecoRepository.save(enderecoEntity);

        restauranteEntity.setEndereco(enderecoEntity);

        restauranteEntity = restauranteRepository.save(restauranteEntity);

        return entityMapper.toRestaurante(restauranteEntity);
    }
}
