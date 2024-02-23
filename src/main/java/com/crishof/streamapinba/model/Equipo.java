package com.crishof.streamapinba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EQUIPOS")
public class Equipo {

    @Id
    private String nombre;
    private String ciudad;
    private String conferencia;
    private String division;
}
