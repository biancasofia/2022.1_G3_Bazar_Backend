package com.fga.bazar.models.dtos;

import com.fga.bazar.models.Categoria;


import javax.persistence.Column;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDto implements Serializable {

    private Integer id;

    private String nome;

    private String icone;

    private final List<ProdutoDto> produtos = new ArrayList<>();

    public CategoriaDto() {

    }

    public CategoriaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.icone = categoria.getIcone();
        categoria.getProdutos()
                .stream()
                .map(ProdutoDto::new)
                .forEach(this.produtos::add);
    }

    public CategoriaDto(Integer id, String nome, String icone) {
        this.id = id;
        this.nome = nome;
        this.icone = icone;
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

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public List<ProdutoDto> getProdutos() {
        return produtos;
    }
}
