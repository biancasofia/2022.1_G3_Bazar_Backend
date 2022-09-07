package com.fga.bazar.controllers;
import com.fga.bazar.models.Produto;
import com.fga.bazar.models.dtos.ProdutoDto;
import com.fga.bazar.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private  ProdutoService produtoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {

        var produto = produtoService.buscarPorId(id);

        return ResponseEntity.ok().body(produto);
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDto>> listarProdutos(
            Pageable pageable,
            @RequestParam(name = "idCategoria", defaultValue = "0") Integer idCategoria
    ) {
        var produtos = produtoService.listarProdutos(idCategoria, pageable);
        return ResponseEntity.ok().body(produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> inserirProduto(@RequestBody Produto produto) {
        produto = produtoService.inserirProduto(produto);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(produto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizarProduto(@PathVariable Integer id, @RequestBody Produto produto) {
        produtoService.atualizarProduto(id, produto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Integer id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }

}
