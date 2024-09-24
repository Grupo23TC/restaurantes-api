package com.fiap.tc.restaurantes.utils.reserva;

import com.fiap.tc.restaurantes.domain.entity.Reserva;
import com.fiap.tc.restaurantes.domain.enums.StatusReservaEnum;
import com.fiap.tc.restaurantes.infra.entity.ReservaEntity;
import com.fiap.tc.restaurantes.utils.mesa.MesaHelper;
import com.fiap.tc.restaurantes.utils.usuario.UsuarioHelper;

import java.time.LocalDateTime;

public class ReservaHelper {

    public static ReservaEntity gerarReservaEntity() {
        ReservaEntity reserva = new ReservaEntity();

        reserva.setUsuarioEntity(UsuarioHelper.gerarUsuarioEntity());
        reserva.setMesaEntity(MesaHelper.gerarMesaEntity());

        reserva.setStatus(StatusReservaEnum.ATIVA);
        reserva.setDataInicio(LocalDateTime.of(2030, 1,1,0,0));
        reserva.setDataFim(LocalDateTime.of(2030, 1,1,2,0));

        return reserva;
    }

    public static Reserva gerarReserva() {

        Reserva reserva = new Reserva();

        reserva.setUsuario(UsuarioHelper.gerarUsuarioValidoComId());
        reserva.setMesa(MesaHelper.gerarMesaComId());

        reserva.setStatus(StatusReservaEnum.ATIVA);
        reserva.setDataInicio(LocalDateTime.now().plusDays(1));
        reserva.setDataFim(LocalDateTime.now().plusDays(1).plusHours(1));

        return reserva;
    }
}
