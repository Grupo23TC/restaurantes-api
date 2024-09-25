package com.fiap.tc.restaurantes.domain.input.reserva;

import java.time.LocalDateTime;

public record CadastrarReservaRequest(
        Long usuarioId,
        Long mesaId,
        LocalDateTime dataInicio,
        LocalDateTime dataFim
) {
}
