package com.fga.bazar.services;
import com.fga.bazar.models.Imagem;
import com.fga.bazar.models.Produto;
import com.fga.bazar.models.dtos.CategoriaDto;
import com.fga.bazar.models.dtos.ProdutoDto;
import com.fga.bazar.repositories.CategoriaRepository;
import com.fga.bazar.repositories.ImagemRepository;
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

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ImagemRepository imagemRepository;

    public Produto buscarPorId(Integer id) {


        return produtoRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public Page<ProdutoDto> listarProdutos(Integer idCategoria, Pageable pageable) {
        if (idCategoria <= 0) {
            return produtoRepository
                    .findAll(pageable)
                    .map(prod -> new ProdutoDto(prod.getId(), prod.getNome(), prod.getPreco(),
                            prod.getCategorias().stream().map(cat -> new CategoriaDto(cat.getId(), cat.getNome())).toList(),
                            imagemRepository.findByProdutoId(prod.getId())));
        }

        return produtoRepository
                .findProdutosPorCategoria(idCategoria, pageable)
                .map(ProdutoDto::new);
    }

    @Transactional
    public ProdutoDto inserirProduto(ProdutoDto produtoDto) {
        var produto = produtoRepository.save(new Produto(produtoDto));
        var finalProduto = produto;

        imagemRepository.saveAll(produtoDto.imagens()
                .stream()
                .map(img -> new Imagem(img.getImagemUrl(), finalProduto)).toList());

        return new ProdutoDto(produto);
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
