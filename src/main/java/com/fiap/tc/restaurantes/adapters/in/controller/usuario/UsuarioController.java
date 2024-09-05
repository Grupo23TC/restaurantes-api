package com.fiap.tc.restaurantes.adapters.in.controller.usuario;

import com.fiap.tc.restaurantes.adapters.in.controller.usuario.mapper.UsuarioMapper;
import com.fiap.tc.restaurantes.adapters.in.controller.usuario.request.AtualizarUsuarioRequest;
import com.fiap.tc.restaurantes.adapters.in.controller.usuario.request.CadastrarUsuarioRequest;
import com.fiap.tc.restaurantes.adapters.in.controller.usuario.response.UsuarioDeletadoResponse;
import com.fiap.tc.restaurantes.adapters.in.controller.usuario.response.UsuarioResponse;
import com.fiap.tc.restaurantes.application.core.domain.Usuario;
import com.fiap.tc.restaurantes.application.ports.in.usuario.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
  private final UsuarioMapper usuarioMapper;

  private final CadastrarUsuarioInputPort cadastrarUsuarioInputPort;
  private final ListarUsuariosInputPort listarUsuariosInputPort;
  private final AtualizarUsuarioInputPort atualizarUsuarioInputPort;
  private final BuscarUsuarioPorIdInputPort buscarUsuarioPorIdInputPort;
  private final DeletarUsuarioInputPort deletarUsuarioInputPort;

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

  @GetMapping
  public ResponseEntity<List<UsuarioResponse>> listarUsuarios() {
    List<Usuario> usuarios = listarUsuariosInputPort.listarUsuarios();
    List<UsuarioResponse> listaUsuarioResponse = usuarios.stream().map(usuarioMapper::toUsuarioResponse).toList();

    return ResponseEntity.ok(listaUsuarioResponse);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UsuarioResponse> atualizarUsuario(
      @PathVariable Long id,
      @RequestBody AtualizarUsuarioRequest usuarioRequest
  ) {
    Usuario usuarioAtualizado = atualizarUsuarioInputPort.atualizarUsuario(id, usuarioMapper.toUsuario(usuarioRequest));
    UsuarioResponse usuarioResponse = usuarioMapper.toUsuarioResponse(usuarioAtualizado);

    return ResponseEntity.ok(usuarioResponse);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UsuarioResponse> buscarUsuario(@PathVariable Long id) {
    Usuario usuarioBuscado = buscarUsuarioPorIdInputPort.buscarUsuarioPorId(id);
    return ResponseEntity.ok(usuarioMapper.toUsuarioResponse(usuarioBuscado));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<UsuarioDeletadoResponse> deletarUsuario(@PathVariable Long id) {
    boolean usuarioFoiDeletado = deletarUsuarioInputPort.deletarUsuario(id);
    return ResponseEntity.ok(new UsuarioDeletadoResponse(usuarioFoiDeletado));
  }
}
