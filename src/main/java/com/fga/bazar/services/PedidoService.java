package com.fga.bazar.services;

import com.fga.bazar.models.Pedido;
import com.fga.bazar.models.dtos.PedidoDto;

import java.time.Instant;

public class PedidoService {
    public PedidoDto realizarPedido(PedidoDto pedidoDto) {
        var pedido = new Pedido();

        pedido.setId(null);
        pedido.setData(Instant.now());

        return null;
    }
}
