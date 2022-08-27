package com.fga.bazar.Factory;

import com.fga.bazar.models.Categoria;
import com.fga.bazar.models.Produto;

public class ProdutoFactory {


    public static Produto criarProduto() {
        var produto = new Produto(1, "Tela de PC",250);
        produto.getCategorias().add(new Categoria(1, "Eletrônicos"));


        return produto;
    }

    public static Categoria criarCategoria() {
        return new Categoria(2, "Eletrônicos");
    }
}
