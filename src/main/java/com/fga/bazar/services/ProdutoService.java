package com.fga.bazar.services;
import com.fga.bazar.models.Produto;
import com.fga.bazar.models.dtos.ProdutoDto;
import com.fga.bazar.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto buscarPorId(Integer id) {


        return produtoRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public Page<ProdutoDto> listarProdutos(Integer idCategoria, Pageable pageable) {
        if (idCategoria <= 0) {
            return produtoRepository.findAll(pageable).map(ProdutoDto::new);
        }

        return produtoRepository
                .findProdutosPorCategoria(idCategoria, pageable)
                .map(ProdutoDto::new);
    }

    public Produto inserirProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Integer id, Produto produto) {
        var produtoAtualizado = this.buscarPorId(id);
        try {
        produtoAtualizado.setNome(produto.getNome());
        produtoAtualizado.setPreco(produto.getPreco());

        return produtoRepository.save(produtoAtualizado); }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirProduto(Integer id) {

        produtoRepository.deleteById(id);
    }
}
