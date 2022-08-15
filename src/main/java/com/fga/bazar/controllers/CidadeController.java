package com.fga.bazar.controllers;

import com.fga.bazar.models.Cidade;
import com.fga.bazar.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/estado/{sigla}")
    public ResponseEntity<List<Cidade>> buscarCidadesPorSiglaDoEstado(@PathVariable String sigla) {
        var cidade = cidadeService.buscarCidadesPorSiglaDoEstado(sigla);
        return ResponseEntity.ok().body(cidade);
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> listarCidades() {
        var cidades = cidadeService.listarCidades();
        return ResponseEntity.ok().body(cidades);
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
