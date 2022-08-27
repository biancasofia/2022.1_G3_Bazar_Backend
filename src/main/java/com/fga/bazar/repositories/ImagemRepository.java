package com.fga.bazar.repositories;

import com.fga.bazar.models.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Integer> {
}
