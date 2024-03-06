package com.crishof.streamapinba;

import com.crishof.streamapinba.model.Equipo;
import com.crishof.streamapinba.model.Estadistica;
import com.crishof.streamapinba.model.Jugador;
import com.crishof.streamapinba.repository.EquipoRepository;
import com.crishof.streamapinba.repository.EstadisticaRepository;
import com.crishof.streamapinba.repository.JugadorRepository;
import com.crishof.streamapinba.repository.PartidoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

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
    public void run(String... args) {

//        menu();

//        1. Mostrar el nombre de todos los jugadores ordenados alfabéticamente.

        var jugadores =
                jugadorRepository.findAll().stream()
                        .sorted(comparing(Jugador::getNombre))
                        .toList();

        System.out.println("jugadores = " + jugadores);

//        2. Mostrar el nombre de los jugadores que sean pivots (‘C’) y que pesen más de 200 libras, ordenados por nombre alfabéticamente.

        var pivots =
                jugadores.stream()
                        .filter(jugador -> jugador.getPosicion().equals("C"))
                        .filter(jugador -> jugador.getPeso() > 200)
                        .sorted(comparing(Jugador::getNombre))
                        .toList();

        System.out.println("pivots = " + pivots);
//        3. Mostrar el nombre de todos los equipos ordenados alfabéticamente.

        var equipos =
                equipoRepository.findAll().stream()
                        .sorted(comparing(Equipo::getNombre))
                        .toList();

        System.out.println("equipos = " + equipos);

//        4. Mostrar el nombre de los equipos del este (East).

        var equipoEast =
                equipoRepository.findAll().stream()
                        .filter(equipo -> equipo.getConferencia().equals("East"))
                        .toList();
        System.out.println("equipoEast = " + equipoEast);

//        5. Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.

        var equiposCiudadConC =
                equipoRepository.findAll().stream()
                        .filter(equipo -> equipo.getCiudad().charAt(0) == 'C')
                        .sorted(comparing(Equipo::getNombre))
                        .toList();
        System.out.println("equiposCiudadConC = " + equiposCiudadConC);

//        6. Mostrar todos los jugadores y su equipo ordenados por nombre del equipo.

        jugadorRepository.findAll().stream()
                .map(jugador -> jugador.getNombre() + ", " + jugador.getEquipo().getNombre())
                .forEach(System.out::println);

//        7. Mostrar todos los jugadores del equipo “Raptors” ordenados por nombre.

        var jugadoresPorNombre =
                jugadorRepository.findAll().stream()
                        .sorted(comparing(Jugador::getNombre))
                        .map(Jugador::getNombre)
                        .toList();
        System.out.println("jugadoresPorNombre = " + jugadoresPorNombre);

//        8. Mostrar los puntos por partido del jugador ‘Pau Gasol’.

        var puntosGasol =
                estadisticaRepository.findAll().stream()
                        .filter(estadistica -> estadistica.getJugador().getNombre().equals("Larry Hughes"))
//                        .map(Estadistica::getPuntosPorPartido)
                        .toList();
        System.out.println("puntosGasol = " + puntosGasol);

//        TODO no funciona con Gasol - REVISAR

//        9. Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.

        var puntosGasolT0405 =
                estadisticaRepository.findAll().stream()
                        .filter(estadistica -> estadistica.getJugador().getNombre().equals("Corey Brever"))
//                        .map(Estadistica::getPuntosPorPartido)
                        .toList();

        System.out.println("puntosGasolT0405 = " + puntosGasolT0405);

//        10. Mostrar el número de puntos de cada jugador en toda su carrera.
//        11. Mostrar el número de jugadores de cada equipo.
//        12. Mostrar el jugador que más puntos ha realizado en toda su carrera.
//        13. Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.
//        14. Mostrar el partido o partidos (equipo_local, equipo_visitante y diferencia) con mayor diferencia de puntos.
//        15. Mostrar quien gana en cada partido (codigo, equipo_local, equipo_visitante, equipo_ganador), en caso de empate sera null.
    }

    public void menu() {
        int option;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("""

                    Ingresar la option para ver el contenido de las tablas

                    1 - Equipos
                    2 - Estadisticas
                    3 - Jugadores
                    4 - Partidos

                    salir 0

                    """);
            option = scanner.nextInt();

            switch (option) {
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
        } while (option != 0);
    }

}
