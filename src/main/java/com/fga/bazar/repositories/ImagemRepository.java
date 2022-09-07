package com.fga.bazar.repositories;

import com.fga.bazar.models.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Integer> {

    List<Imagem> findByProdutoId(@Param("produtoId") Integer produtoId);

}
