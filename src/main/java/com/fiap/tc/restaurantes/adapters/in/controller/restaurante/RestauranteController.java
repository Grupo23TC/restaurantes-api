package com.fiap.tc.restaurantes.adapters.in.controller.restaurante;

import com.fiap.tc.restaurantes.adapters.in.controller.restaurante.mapper.RestauranteMapper;
import com.fiap.tc.restaurantes.adapters.in.controller.restaurante.request.CadastrarRestauranteRequest;
import com.fiap.tc.restaurantes.adapters.in.controller.restaurante.response.RestauranteResponse;
import com.fiap.tc.restaurantes.application.core.domain.Restaurante;
import com.fiap.tc.restaurantes.application.ports.in.CadastrarRestauranteInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/restaurante")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteMapper restauranteMapper;

    private final CadastrarRestauranteInputPort cadastrarRestauranteInputPort;

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


}
