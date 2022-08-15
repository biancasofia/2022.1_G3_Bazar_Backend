package com.fga.bazar.controllers;

import com.fga.bazar.models.dtos.NovoUsuarioDto;
import com.fga.bazar.models.dtos.UsuarioDto;
import com.fga.bazar.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> cadastrarCliente(@RequestBody NovoUsuarioDto novoUsuarioDto) {
        var usuarioCadastrado = usuarioService.cadastrarCliente(novoUsuarioDto);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioCadastrado.getId())
                .toUri();

        return ResponseEntity.created(uri).body(usuarioCadastrado);
    }

}
