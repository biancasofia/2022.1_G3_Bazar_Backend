package com.fga.bazar.models.dtos;

import com.fga.bazar.models.Categoria;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDto implements Serializable {

    private Integer id;

    private String nome;

    private final List<ProdutoDto> produtos = new ArrayList<>();

    public CategoriaDto() {

    }

    public CategoriaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        categoria.getProdutos()
                .stream()
                .map(ProdutoDto::new)
                .forEach(this.produtos::add);
    }

    public CategoriaDto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ProdutoDto> getProdutos() {
        return produtos;
    }
}
