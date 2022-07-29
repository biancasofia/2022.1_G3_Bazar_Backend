package com.fga.bazar.repositories;

import com.fga.bazar.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    @Query("SELECT objCidade FROM Cidade objCidade WHERE LOWER(objCidade.estado.sigla) = LOWER(:sigla)")
    List<Cidade> buscarCidadesPorSiglaDoEstado(String sigla);

}
