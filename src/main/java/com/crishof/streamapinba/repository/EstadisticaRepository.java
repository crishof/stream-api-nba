package com.crishof.streamapinba.repository;

import com.crishof.streamapinba.model.Estadistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica, String> {
}
