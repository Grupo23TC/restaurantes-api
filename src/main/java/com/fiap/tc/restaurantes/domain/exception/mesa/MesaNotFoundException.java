package com.fiap.tc.restaurantes.domain.exception.mesa;

public class MesaNotFoundException extends RuntimeException {
    public MesaNotFoundException(String message) {
        super(message);
    }
}
