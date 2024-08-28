package com.fiap.tc.restaurantes.adapters.in.controller.restaurante;

import com.fiap.tc.restaurantes.adapters.in.controller.restaurante.mapper.RestauranteMapper;
import com.fiap.tc.restaurantes.adapters.in.controller.restaurante.request.AtualizarRestauranteRequest;
import com.fiap.tc.restaurantes.adapters.in.controller.restaurante.request.CadastrarRestauranteRequest;
import com.fiap.tc.restaurantes.adapters.in.controller.restaurante.response.RestauranteResponse;
import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.ports.in.restaurante.AtualizarRestauranteInputPort;
import com.fiap.tc.restaurantes.application.ports.in.restaurante.CadastrarRestauranteInputPort;
import com.fiap.tc.restaurantes.application.ports.in.restaurante.DeletarRestauranteInputPort;
import com.fiap.tc.restaurantes.application.ports.in.restaurante.ListarRestauranteInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/restaurante")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteMapper restauranteMapper;

    private final CadastrarRestauranteInputPort cadastrarRestauranteInputPort;
    private final ListarRestauranteInputPort listarRestauranteInputPort;
    private final DeletarRestauranteInputPort deletarRestauranteInputPort;
    private final AtualizarRestauranteInputPort atualizarRestauranteInputPort;


  @PostMapping
    public ResponseEntity<RestauranteResponse> cadastrarRestaurante(@RequestBody CadastrarRestauranteRequest request) {

        Restaurante restaurante = restauranteMapper.toRestaurante(request);

        RestauranteResponse restauranteResponse = restauranteMapper.toRestauranteResponse(cadastrarRestauranteInputPort.cadastrarRestaurante(restaurante));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(restauranteResponse.restauranteId())
                .toUri();
        return ResponseEntity.created(uri).body(restauranteResponse);
    }

  @PutMapping("/{id}")
  public ResponseEntity<RestauranteResponse> atualizarRestaurante(@PathVariable Long id, @RequestBody AtualizarRestauranteRequest request) {
    Restaurante restaurante = restauranteMapper.toRestaurante(request);

    RestauranteResponse restauranteResponse = restauranteMapper.toRestauranteResponse(atualizarRestauranteInputPort.atualizarRestaurante(id, restaurante));

    return ResponseEntity.status(HttpStatus.OK).body(restauranteResponse);
  }


    @GetMapping
    public ResponseEntity<List<RestauranteResponse>> listRestaurantes() {
        List<RestauranteResponse> listaRestaurante = listarRestauranteInputPort.listarRestaurantes()
            .stream()
            .map(restauranteMapper::toRestauranteResponse)
            .toList();
        return ResponseEntity.status(HttpStatus.OK).body(listaRestaurante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarRestaurante(@PathVariable Long id) {
        //TODO implementar json de restaurante deletado
        Boolean foiDeletado = deletarRestauranteInputPort.deletarRestaurante(id);
        return ResponseEntity.status(HttpStatus.OK).body(foiDeletado);
    }
}
