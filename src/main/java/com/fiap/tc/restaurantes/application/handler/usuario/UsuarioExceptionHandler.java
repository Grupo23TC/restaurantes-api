package com.fiap.tc.restaurantes.application.handler.usuario;

import com.fiap.tc.restaurantes.application.handler.exception.ErroCustomizado;
import com.fiap.tc.restaurantes.domain.exception.usuario.UsuarioNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class UsuarioExceptionHandler {

  @ExceptionHandler(UsuarioNotFoundException.class)
  public ResponseEntity<ErroCustomizado> handleUsuarioNotFoundException(UsuarioNotFoundException ex, HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    ErroCustomizado erro = new ErroCustomizado(
        Instant.now(),
        ex.getMessage(),
        status.value(),
        request.getRequestURI()
    );

    return new ResponseEntity<>(erro, status);
  }
}
