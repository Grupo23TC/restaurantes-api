package com.fiap.tc.restaurantes.adapters.out.restaurante;

import com.fiap.tc.restaurantes.adapters.out.repository.EnderecoRepository;
import com.fiap.tc.restaurantes.adapters.out.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.adapters.out.repository.entity.EnderecoEntity;
import com.fiap.tc.restaurantes.adapters.out.repository.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.adapters.out.repository.mapper.EnderecoEntityMapper;
import com.fiap.tc.restaurantes.adapters.out.repository.mapper.RestauranteEntityMapper;
import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.ports.out.restaurante.AtualizarRestauranteOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AtualizarRestauranteAdapter implements AtualizarRestauranteOutputPort {

  private final RestauranteRepository restauranteRepository;
  private final RestauranteEntityMapper entityMapper;

  // TODO ver em qual camada orquestrar esse insert na table de endereco
//  private final EnderecoRepository enderecoRepository;
//  private final EnderecoEntityMapper enderecoEntityMapper;

  @Override
  public Restaurante atualizarRestaurante(Long restauranteId, Restaurante restaurante) {
    RestauranteEntity restauranteEntity = buscarRestaurantePorId(restauranteId);

    //TODO falta pegar o Endereço
    restauranteEntity.setCapacidade(restaurante.getCapacidade());
    restauranteEntity.setNome(restaurante.getNome());
    restauranteEntity.setHorarioFuncionamento(restaurante.getHorarioFuncionamento());
    restauranteEntity.setTipoDeCozinha(restaurante.getTipoDeCozinha().toString());

    RestauranteEntity restauranteAtualizado = restauranteRepository.save(restauranteEntity);

    return entityMapper.toRestaurante(restauranteAtualizado);
  }

  @Override
  public RestauranteEntity buscarRestaurantePorId(Long restauranteId){

    RestauranteEntity restaurante = restauranteRepository.findById(restauranteId)
        .orElseThrow(() -> new RuntimeException());

    return restaurante;
  }
}
