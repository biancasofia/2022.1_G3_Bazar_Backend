package com.fga.bazar.controllers;

import com.fga.bazar.models.Estado;
import com.fga.bazar.models.dtos.EstadoDto;
import com.fga.bazar.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estado> buscarPorId(@PathVariable Integer id) {
        var estado = estadoService.buscarPorId(id);
        return ResponseEntity.ok().body(estado);
    }

    @GetMapping
    public ResponseEntity<List<Estado>> listarEstados() {
        var estados = estadoService.listarEstados();
        return ResponseEntity.ok().body(estados);
    }

    @PostMapping
    public ResponseEntity<EstadoDto> inserir(@RequestBody EstadoDto estado) {
        estado = estadoService.inserir(estado);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(estado.getId())
                .toUri();

        return ResponseEntity.created(uri).body(estado);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizarEstado(@PathVariable Integer id, @RequestBody Estado estado) {
        estadoService.atualizarEstado(id, estado);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirEstado(@PathVariable Integer id) {
        estadoService.excluirEstado(id);
        return ResponseEntity.noContent().build();
    }

}
