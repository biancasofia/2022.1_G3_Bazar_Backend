package com.fga.bazar.controllers;

import com.fga.bazar.models.Cidade;
import com.fga.bazar.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cidade> buscarPorId(@PathVariable Integer id) {
        var cidade = cidadeService.buscarPorId(id);
        return ResponseEntity.ok().body(cidade);
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> listarCidades() {
        var cidades = cidadeService.listarCidades();
        return ResponseEntity.ok().body(cidades);
    }

    @PostMapping
    public ResponseEntity<Cidade> inserir(@RequestBody Cidade cidade) {
        cidade = cidadeService.inserir(cidade);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cidade.getId())
                .toUri();

        return ResponseEntity.created(uri).body(cidade);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizarCidade(@PathVariable Integer id, @RequestBody Cidade cidade) {
        cidadeService.atualizarCidade(id, cidade);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirCidade(@PathVariable Integer id) {
        cidadeService.excluirCidade(id);
        return ResponseEntity.noContent().build();
    }

}
