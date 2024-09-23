package com.fiap.tc.restaurantes.domain.input.reserva;

import com.fiap.tc.restaurantes.domain.enums.StatusReservaEnum;

import java.time.LocalDateTime;

public record AtualizarReservaRequest(
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        StatusReservaEnum status
) {
}
