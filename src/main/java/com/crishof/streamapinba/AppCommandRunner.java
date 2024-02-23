package com.crishof.streamapinba;

import com.crishof.streamapinba.repository.EquipoRepository;
import com.crishof.streamapinba.repository.EstadisticaRepository;
import com.crishof.streamapinba.repository.JugadorRepository;
import com.crishof.streamapinba.repository.PartidoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class AppCommandRunner implements CommandLineRunner {

    @Autowired
    JugadorRepository jugadorRepository;
    @Autowired
    EquipoRepository equipoRepository;
    @Autowired
    EstadisticaRepository estadisticaRepository;
    @Autowired
    PartidoRepository partidoRepository;

    @Override
    public void run(String... args) throws Exception {

        int opcion;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("""
                                        
                    Ingresar la opcion para ver el contenido de las tablas
                                        
                    1 - Equipos
                    2 - Estadisticas
                    3 - Jugadores
                    4 - Partidos
                                        
                    salir 0
                                        
                    """);
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: {
                    log.info("Equipo:");
                    equipoRepository.findAll().forEach(equipo -> System.out.println(equipo.toString()));
                    break;
                }
                case 2: {
                    log.info("Estadistica:");
                    estadisticaRepository.findAll().forEach(estadistica -> System.out.println(estadistica.toString()));
                    break;

                }
                case 3: {

                    log.info("Jugadores:");
                    jugadorRepository.findAll().forEach(jugador -> System.out.println(jugador.toString()));
                    break;
                }
                case 4: {

                    log.info("Partido:");
                    partidoRepository.findAll().forEach(partido -> System.out.println(partido.toString()));
                    break;
                }
            }
        } while (opcion != 0);


    }
}
