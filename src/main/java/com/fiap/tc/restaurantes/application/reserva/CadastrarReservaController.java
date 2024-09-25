package com.fiap.tc.restaurantes.application.reserva;

import com.fiap.tc.restaurantes.domain.entity.Reserva;
import com.fiap.tc.restaurantes.domain.input.reserva.CadastrarReservaRequest;
import com.fiap.tc.restaurantes.domain.mapper.reserva.ReservaMapper;
import com.fiap.tc.restaurantes.domain.output.reserva.ReservaResponse;
import com.fiap.tc.restaurantes.domain.usecase.reserva.CadastrarReservaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class CadastrarReservaController {

    private final CadastrarReservaUseCase cadastrarReservaUseCase;
    private final ReservaMapper mapper;

    @PostMapping
    public ResponseEntity<ReservaResponse> cadastrarReserva(@RequestBody CadastrarReservaRequest request) {
        Reserva reserva = cadastrarReservaUseCase.cadastrarReserva(mapper.toReserva(request), request.usuarioId(), request.mesaId());
        return ResponseEntity.ok(mapper.toReservaResponse(reserva));
    }
}
