package com.fga.bazar.controllers;

import com.fga.bazar.models.Pedido;
import com.fga.bazar.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> realizarPedido(@RequestBody Pedido pedido) {
        var pedidoRealizado = pedidoService.realizarPedido(pedido);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pedidoRealizado.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

}
