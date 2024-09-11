package com.fiap.tc.restaurantes.application.usuario;

import com.fiap.tc.restaurantes.domain.mapper.usuario.UsuarioMapper;
import com.fiap.tc.restaurantes.domain.input.usuario.CadastrarUsuarioRequest;
import com.fiap.tc.restaurantes.domain.output.usuario.UsuarioResponse;
import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.useCase.usuario.CadastrarUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
  public class CadastrarUsuarioController {

    private final UsuarioMapper usuarioMapper;
    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody CadastrarUsuarioRequest cadastrarUsuarioRequest) {
      Usuario usuario = usuarioMapper.toUsuario(cadastrarUsuarioRequest);

      Usuario usuarioCadastrado = cadastrarUsuarioUseCase.cadastrarUsuario(usuario);

      UsuarioResponse usuarioResponse = usuarioMapper.toUsuarioResponse(usuarioCadastrado);

      URI uri = ServletUriComponentsBuilder
          .fromCurrentRequest()
          .path("/{id}")
          .buildAndExpand(usuarioResponse.usuarioId())
          .toUri();

      return ResponseEntity.created(uri).body(usuarioResponse);
    }
  }
