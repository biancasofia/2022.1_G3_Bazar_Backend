package com.fga.bazar.models.dtos;

import com.fga.bazar.models.Imagem;
import com.fga.bazar.models.Produto;

import java.io.Serializable;
import java.util.List;

public record ProdutoDto(
        Integer id,
        String nome,
        Float preco,

        List<CategoriaDto> categorias,
        List<Imagem> imagens
) implements Serializable {

    public ProdutoDto(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getPreco(),
                produto.getCategorias().stream().map(cat -> new CategoriaDto(cat.getId(), cat.getNome())).toList(),
                produto.getImagens()
        );
    }

}
