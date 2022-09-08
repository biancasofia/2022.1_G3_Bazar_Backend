package com.fga.bazar.controllers;

import com.fga.bazar.models.Endereco;
import com.fga.bazar.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> obterTodosOsEnderecosDoUsuarioLogado() {
        return ResponseEntity.ok().body(enderecoService.obterTodosOsEnderecosDoUsuarioLogado());
    }

}
