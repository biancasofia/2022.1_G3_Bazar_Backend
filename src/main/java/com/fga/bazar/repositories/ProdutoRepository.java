package com.fga.bazar.repositories;
import com.fga.bazar.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT DISTINCT obj " +
            "FROM Produto obj INNER JOIN obj.categorias cat " +
            "WHERE cat.id = :idCategoria")
    Page<Produto> findProdutosPorCategoria(@Param("idCategoria") Integer idCategoria, Pageable pageable);

}
