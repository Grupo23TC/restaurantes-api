package com.fiap.tc.restaurantes.adapters.in.controller.usuario;

import com.fiap.tc.restaurantes.adapters.in.controller.usuario.mapper.UsuarioMapper;
import com.fiap.tc.restaurantes.adapters.in.controller.usuario.request.CadastrarUsuarioRequest;
import com.fiap.tc.restaurantes.adapters.in.controller.usuario.response.UsuarioResponse;
import com.fiap.tc.restaurantes.application.core.domain.Usuario;
import com.fiap.tc.restaurantes.application.ports.in.usuario.CadastrarUsuarioInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
  private final UsuarioMapper usuarioMapper;

  private final CadastrarUsuarioInputPort cadastrarUsuarioInputPort;

  @PostMapping
  public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody CadastrarUsuarioRequest cadastrarUsuarioRequest) {
    Usuario usuario = usuarioMapper.toUsuario(cadastrarUsuarioRequest);

    Usuario usuarioCadastrado = cadastrarUsuarioInputPort.cadastrarUsuario(usuario);

    UsuarioResponse usuarioResponse = usuarioMapper.toUsuarioResponse(usuarioCadastrado);

    URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(usuarioResponse.usuarioId())
        .toUri();

    return ResponseEntity.created(uri).body(usuarioResponse);
  }
}
