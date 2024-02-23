package com.crishof.streamapinba.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estadisticas")
public class Estadistica {

    @Id
    private String temporada;
    @OneToOne
    private Jugador jugador;
    @Column(name = "puntos_por_partido")
    private float puntosPorPartido;
    @Column(name = "asistencias_por_partido")
    private float asistenciasPorPartido;
    @Column(name = "tapones_por_partido")
    private float taponesPorPartido;
    @Column(name = "rebotes_por_partido")
    private float rebotesPorPartido;
}
