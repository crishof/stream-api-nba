package com.crishof.streamapinba.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jugadores")
public class Jugador {

    @Id
    private Integer codigo;
    private String nombre;
    private String procedencia;
    private String altura;
    private int peso;
    private String posicion;
    @ManyToOne
    @JoinColumn(name = "Nombre_equipo")
    private Equipo equipo;
}
