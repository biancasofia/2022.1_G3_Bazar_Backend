package com.fga.bazar.repositories;

import com.fga.bazar.models.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<Imagem, Integer> {
}
