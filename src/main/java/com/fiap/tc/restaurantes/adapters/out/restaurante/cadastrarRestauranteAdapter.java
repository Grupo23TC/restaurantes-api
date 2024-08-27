package com.fiap.tc.restaurantes.adapters.out.restaurante;

import com.fiap.tc.restaurantes.adapters.out.repository.EnderecoRepository;
import com.fiap.tc.restaurantes.adapters.out.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.adapters.out.repository.entity.EnderecoEntity;
import com.fiap.tc.restaurantes.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.adapters.out.repository.mapper.EnderecoEntityMapper;
import com.fiap.tc.restaurantes.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.ports.out.CadastrarRestauranteOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class cadastrarRestauranteAdapter implements CadastrarRestauranteOutputPort {

    private final RestauranteRepository restauranteRepository;
    private final RestauranteEntityMapper entityMapper;

    // TODO ver em qual camada orquestrar esse insert na table de endereco
    private final EnderecoRepository enderecoRepository;
    private final EnderecoEntityMapper enderecoEntityMapper;

    @Override
    public Restaurante cadastrarRestaurante(Restaurante restaurante) {

        RestauranteEntity restauranteEntity = entityMapper.toRestauranteEntity(restaurante);

        // TODO ver em qual camada orquestrar esse insert na table de endereco
        EnderecoEntity enderecoEntity = enderecoEntityMapper.toEnderecoEntity(restaurante.getLocalizacao());

        enderecoEntity = enderecoRepository.save(enderecoEntity);

        restauranteEntity.setLocalizacao(enderecoEntity);

        restauranteEntity = restauranteRepository.save(restauranteEntity);

        return entityMapper.toRestaurante(restauranteEntity);
    }
}
