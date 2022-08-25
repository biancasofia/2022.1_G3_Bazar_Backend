package com.fga.bazar.models.dtos;

import com.fga.bazar.models.Produto;

import java.io.Serializable;

public record ProdutoDto(
        Integer id,
        String nome,
        Float preco
) implements Serializable {

    public ProdutoDto(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getPreco());
    }

}
