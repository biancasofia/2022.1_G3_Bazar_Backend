package com.fga.bazar.repositories;

import com.fga.bazar.models.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Integer> {
}
