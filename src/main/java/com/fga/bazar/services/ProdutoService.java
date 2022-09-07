package com.fga.bazar.services;
import com.fga.bazar.models.Produto;
import com.fga.bazar.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto buscarPorId(Integer id) {


        return produtoRepository.findById(id).orElseThrow();
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto inserirProduto(Produto produto) {
        return produtoRepository.save(produto);
    }



    public Produto atualizarProduto(Integer id, Produto produto) {
        var produtoAtualizado = this.buscarPorId(id);

        produtoAtualizado.setNome(produto.getNome());
        produtoAtualizado.setPreco(produto.getPreco());

        return produtoRepository.save(produtoAtualizado);
    }

    public void excluirProduto(Integer id) {

        produtoRepository.deleteById(id);
    }
}
