package com.fga.bazar.controllers;
import com.fga.bazar.models.Categoria;
import com.fga.bazar.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @PostMapping
    public ResponseEntity<Categoria> inserir(@RequestBody Categoria categoria) {
        categoria = categoriaService.inserir(categoria);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoria.getId())
                .toUri();

        return ResponseEntity.created(uri).body(categoria);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer id) {
        var categoria = categoriaService.buscarPorId(id);

        return ResponseEntity.ok().body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> buscarCidades() {
        var categorias = categoriaService.buscarCidades();
        return ResponseEntity.ok().body(categorias);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        categoriaService.atualizarCategoria(id, categoria);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirCategoria(@PathVariable Integer id) {
        categoriaService.excluirCategoria(id);
        return ResponseEntity.noContent().build();
    }
}