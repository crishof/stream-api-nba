package com.crishof.streamapinba.repository;

import com.crishof.streamapinba.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, String> {
}
