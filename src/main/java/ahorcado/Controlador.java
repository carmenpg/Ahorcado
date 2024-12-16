/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahorcado;

/**
 *
 * @author carmenperezgomez
 */



import ahorcado.Ahorcado;
import ahorcado.Vista;
import java.util.Scanner;

public class Controlador {

    private Vista vista;
    private Scanner scanner;

    public Controlador() {
        this.vista = new Vista();
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        vista.mostrarMensaje("\n--- Bienvenido al juego del Ahorcado para dos jugadores ---\n");

        int puntuacionJugador1 = 0;
        int puntuacionJugador2 = 0;
        final int MAX_PARTIDAS = 5;

        for (int partida = 1; partida <= MAX_PARTIDAS; partida++) {
            vista.mostrarMensaje("\nPartida " + partida + " de " + MAX_PARTIDAS);

            String jugadorActual = (partida % 2 == 1) ? "Jugador 1" : "Jugador 2";
            String jugadorAdivinador = (partida % 2 == 1) ? "Jugador 2" : "Jugador 1";

            vista.mostrarMensaje(jugadorActual + " debe escribir una palabra para que " + jugadorAdivinador + " la adivine.");
            vista.mostrarMensaje("Introduce una palabra: ");
            String palabra = vista.pedirPalabra();

            vista.limpiarPantalla();
            Ahorcado ahorcado = new Ahorcado(palabra);

            jugarAhorcado(ahorcado, jugadorAdivinador);

            // Actualizar puntuaciones
            if (ahorcado.estaAdivinada()) {
                if (jugadorAdivinador.equals("Jugador 1")) {
                    puntuacionJugador1++;
                } else {
                    puntuacionJugador2++;
                }
            }

            vista.mostrarPuntuaciones(puntuacionJugador1, puntuacionJugador2);
        }

        mostrarResultadoFinal(puntuacionJugador1, puntuacionJugador2);


            vista.mostrarMensaje("\nPuntuaciones actuales: Jugador 1: " + puntuacionJugador1 + " | Jugador 2: " + puntuacionJugador2);

    }

        
    

    private void jugarAhorcado(Ahorcado ahorcado, String jugadorAdivinador) {
        while (ahorcado.tieneErroresDisponibles() && !ahorcado.estaAdivinada()) {
            vista.mostrarDibujo(ahorcado.getErrores());
            vista.mostrarProgreso(ahorcado.getProgreso());
            char letra = vista.pedirLetra(jugadorAdivinador);

            boolean acierto = ahorcado.adivinarLetra(letra);
            if (!acierto) {
                vista.mostrarMensaje("¡Fallaste! Intenta nuevamente.");
            } else {
                vista.mostrarMensaje("¡Bien hecho! Adivinaste una letra.");
            }
        }

        if (ahorcado.estaAdivinada()) {
            vista.mostrarMensaje("¡Felicidades, " + jugadorAdivinador + "! Adivinaste la palabra: " + ahorcado.getPalabraSecreta());
        } else {
            vista.mostrarDibujo(6);
            vista.mostrarMensaje("Lo siento, " + jugadorAdivinador + ". La palabra era: " + ahorcado.getPalabraSecreta());
        }
    }


    private void mostrarResultadoFinal(int puntuacionJugador1, int puntuacionJugador2) {
        vista.mostrarMensaje("\n--- Fin del juego ---");
        if (puntuacionJugador1 > puntuacionJugador2) {
            vista.mostrarMensaje("Ganador: Jugador 1!");
        } else if (puntuacionJugador2 > puntuacionJugador1) {
            vista.mostrarMensaje("Ganador: Jugador 2!");
        } else {
            vista.mostrarMensaje("Empate!");
        }
    }


}

