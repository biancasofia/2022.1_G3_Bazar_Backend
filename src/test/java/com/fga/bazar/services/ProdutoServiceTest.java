package com.fga.bazar.services;

import com.fga.bazar.Factory.ProdutoFactory;
import com.fga.bazar.models.Categoria;
import com.fga.bazar.models.Produto;
import com.fga.bazar.repositories.CategoriaRepository;
import com.fga.bazar.repositories.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.aspectj.bridge.MessageUtil.fail;

@ExtendWith(SpringExtension.class)
public class ProdutoServiceTest {
    @InjectMocks
    private ProdutoService produtoService;
    @Mock
    private ProdutoRepository produtoRepository;
    @Mock
    private CategoriaRepository categoriaRepository;

    private int idExistente;
    private int idNExistente;
    private int idDependente;
    private int idCategoria;
    private String nome;
    private Produto produto;
    private Categoria categoria;

    @BeforeEach
    void setUp() throws Exception {
        this.idExistente = 1;
        this.idNExistente = 1000;
        this.idDependente = 4;
        this.idCategoria = 5;
        this.nome = "";
        this.produto = ProdutoFactory.criarProduto();

        this.categoria = ProdutoFactory.criarCategoria();


        Mockito.when(this.produtoRepository.save(ArgumentMatchers.any()))
                .thenReturn(produto);

        Mockito.when(this.produtoRepository.getById(idExistente))
                .thenReturn(produto);

        Mockito.when(this.produtoRepository.getById(idNExistente))
                .thenThrow(EntityNotFoundException.class);

        Mockito.when(this.produtoRepository.findById(idExistente))
                .thenReturn(Optional.of(produto));

        Mockito.when(this.produtoRepository.findById(idNExistente))
                .thenReturn(Optional.empty());

        Mockito.when(this.categoriaRepository.getById(idExistente))
                .thenReturn(categoria);

        Mockito.when(this.categoriaRepository.getById(idNExistente))
                .thenThrow(EntityNotFoundException.class);

        Mockito.doNothing()
                .when(this.produtoRepository).deleteById(idExistente);

        Mockito.doThrow(EmptyResultDataAccessException.class)
                .when(this.produtoRepository).deleteById(idNExistente);

        Mockito.doThrow(DataIntegrityViolationException.class)
                .when(this.produtoRepository).deleteById(idDependente);

    }
    @Test
    public void updateDeveRetornarProdutoIdExiste() {
        var produto = ProdutoFactory.criarProduto();
        var resultado = this.produtoService.atualizarProduto(this.idExistente, produto);

        Assertions.assertNotNull(resultado);

       Mockito.verify(this.produtoRepository, Mockito.times(1))
               .save(this.produto);
        // fail("Ainda não implementado");
    }


    @Test
    public void updateDeveRetornarErroIdNExiste() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            var produto1 = new Produto();
            this.produtoService.atualizarProduto(this.idNExistente, produto1);
        });

        this.produto.setId(idNExistente);

        Mockito.verify(this.produtoRepository, Mockito.times(0))
                .save(this.produto);
    }


}
