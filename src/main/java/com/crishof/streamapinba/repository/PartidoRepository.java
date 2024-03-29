package com.crishof.streamapinba.repository;

import com.crishof.streamapinba.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {
}
