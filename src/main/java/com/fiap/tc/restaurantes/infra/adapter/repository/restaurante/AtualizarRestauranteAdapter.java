package com.fiap.tc.restaurantes.infra.adapter.repository.restaurante;

import com.fiap.tc.restaurantes.infra.repository.RestauranteRepository;
import com.fiap.tc.restaurantes.infra.entity.RestauranteEntity;
import com.fiap.tc.restaurantes.infra.repository.mapper.RestauranteEntityMapper;
import com.fiap.tc.restaurantes.domain.entity.Restaurante;
import com.fiap.tc.restaurantes.domain.gateway.restaurante.AtualizarRestauranteInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AtualizarRestauranteAdapter implements AtualizarRestauranteInterface {

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

    return restauranteRepository.findById(restauranteId)
        .orElseThrow(RuntimeException::new);
  }
}
