package com.fiap.tc.restaurantes.application.usuario;

import com.fiap.tc.restaurantes.domain.entity.Usuario;
import com.fiap.tc.restaurantes.domain.mapper.usuario.UsuarioMapper;
import com.fiap.tc.restaurantes.domain.output.usuario.UsuarioResponse;
import com.fiap.tc.restaurantes.domain.usecase.usuario.ListarUsuariosUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class ListarUsuariosController {

    private final UsuarioMapper usuarioMapper;
    private final ListarUsuariosUseCase listarUsuariosUseCase;

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarUsuarios() {
        List<Usuario> usuarios = listarUsuariosUseCase.listarUsuarios();
        List<UsuarioResponse> listaUsuarioResponse = usuarios.stream().map(usuarioMapper::toUsuarioResponse).toList();

        return ResponseEntity.ok(listaUsuarioResponse);
    }

}
