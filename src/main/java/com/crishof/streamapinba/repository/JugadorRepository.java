package com.crishof.streamapinba.repository;

import com.crishof.streamapinba.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador,Integer> {
}
