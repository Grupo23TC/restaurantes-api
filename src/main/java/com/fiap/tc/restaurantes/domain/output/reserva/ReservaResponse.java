package com.fiap.tc.restaurantes.domain.output.reserva;

import com.fiap.tc.restaurantes.domain.enums.StatusReservaEnum;

import java.time.LocalDateTime;

public record ReservaResponse(
        Long reservaId,
        Long mesaId,
        Long usuarioId,
        StatusReservaEnum status,
        LocalDateTime dataInicio,
        LocalDateTime dataFim
) {
}
