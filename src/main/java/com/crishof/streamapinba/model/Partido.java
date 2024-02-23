package com.crishof.streamapinba.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "partidos")
public class Partido {

    @Id
    private Integer codigo;
    @ManyToOne
    @JoinColumn(name = "equipo_local", referencedColumnName = "Nombre")
    private Equipo equipoLocal;
    @ManyToOne
    @JoinColumn(name = "equipo_visitante", referencedColumnName = "Nombre")
    private Equipo equipoVisitante;
    private int puntosLocal;
    private int puntosVisitante;
    private String temporada;
}
