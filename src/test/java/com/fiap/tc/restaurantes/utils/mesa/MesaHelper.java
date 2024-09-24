package com.fiap.tc.restaurantes.utils.mesa;

import com.fiap.tc.restaurantes.domain.entity.Mesa;
import com.fiap.tc.restaurantes.infra.entity.MesaEntity;
import com.fiap.tc.restaurantes.utils.restaurante.RestauranteHelper;

public class MesaHelper {

    public static MesaEntity gerarMesaEntity() {
        MesaEntity mesa = new MesaEntity();

        mesa.setRestauranteEntity(RestauranteHelper.gerarRestauranteEntityValido());
        mesa.setQuantidadeAssentos(4);

        return mesa;
    }

    public static Mesa gerarMesa() {
        Mesa mesa = new Mesa();

        mesa.setRestaurante(RestauranteHelper.gerarRestaurante());
        mesa.setQuantidadeAssentos(4);

        return mesa;
    }

    public static Mesa gerarMesaComId() {
        Mesa mesa = new Mesa();

        mesa.setMesaId(1L);
        mesa.setRestaurante(RestauranteHelper.gerarRestaurante());
        mesa.setQuantidadeAssentos(4);

        return mesa;
    }
}
