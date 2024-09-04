package com.fiap.tc.restaurantes.application.core.domain.validation.usuario;

public class PasswordValidator {
  private static final String SENHA_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";

  public static boolean isValid(String password) {
    return password.matches(SENHA_REGEX);
  }
}
