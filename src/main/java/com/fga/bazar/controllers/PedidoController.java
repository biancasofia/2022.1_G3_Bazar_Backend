package com.fga.bazar.controllers;

import com.fga.bazar.models.Pedido;
import com.fga.bazar.models.dtos.PedidoDto;
import com.fga.bazar.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<Page<PedidoDto>> listarPedidos(Pageable pageable) {
        var pedidos = pedidoService.listarPedidos(pageable);
        return ResponseEntity.ok().body(pedidos);
    }

    @GetMapping(value = "/meus-pedidos")
    public ResponseEntity<Page<PedidoDto>> listarPedidosDoUsuarioLogado(Pageable pageable) {
        var pedidos = pedidoService.listarPedidosDoUsuarioLogado(pageable);
        return ResponseEntity.ok().body(pedidos);
    }

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
