package com.fiap.tc.restaurantes.domain.exception.restaurante;

public class RestauranteNotFoundException extends RuntimeException {
    public RestauranteNotFoundException(String message) {
        super(message);
    }
}
