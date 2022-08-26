package com.fga.bazar.controllers;


import com.fga.bazar.models.Imagem;
import com.fga.bazar.services.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/imagens")
public class ImagemController {



    @Autowired
    private ImagemService imagemService;


    @PostMapping
    public ResponseEntity<Imagem> inserir(@RequestBody Imagem imagem) {
        imagem = imagemService.inserir(imagem);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(imagem.getId())
                .toUri();

        return ResponseEntity.created(uri).body(imagem);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirImagem(@PathVariable Integer id) {
        imagemService.excluirImagem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Imagem>> listarImagens() {
        var imagens = imagemService.listarImagens();
        return ResponseEntity.ok().body(imagens);
    }




}
