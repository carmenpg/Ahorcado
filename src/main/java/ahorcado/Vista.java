package ahorcado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author carmenperezgomez
 */


public class Vista {

    private static final String[] AHORCADO = {
        "\n  +---+\n      |\n      |\n      |\n     ===", // 0 errores
        "\n  +---+\n  O   |\n      |\n      |\n     ===", // 1 error
        "\n  +---+\n  O   |\n  |   |\n      |\n     ===", // 2 errores
        "\n  +---+\n  O   |\n /|   |\n      |\n     ===", // 3 errores
        "\n  +---+\n  O   |\n /|\\  |\n      |\n     ===", // 4 errores
        "\n  +---+\n  O   |\n /|\\  |\n /    |\n     ===", // 5 errores
        "\n  +---+\n  O   |\n /|\\  |\n / \\  |\n     ==="  // 6 errores
    };

    public void mostrarDibujo(int errores) {
        System.out.println(AHORCADO[errores]);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println(); // Imprime varias líneas en blanco
        }
    }
    
    
    public String pedirPalabra() {
        System.out.println("Por favor, introduce una palabra secreta:");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.next().toUpperCase();
    }

    // Pide una letra al jugador
    public char pedirLetra(String jugador) {
        System.out.println(jugador + ", introduce una letra:");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String entrada = scanner.next().toUpperCase();

        if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
            System.out.println("Por favor, introduce solo una letra.");
            return pedirLetra(jugador);
        }

        return entrada.charAt(0);
    }

    // Muestra el progreso de la palabra
    public void mostrarProgreso(String progreso) {
        System.out.println("Progreso actual: " + progreso);
    }

    // Muestra las puntuaciones actuales
    public void mostrarPuntuaciones(int jugador1, int jugador2) {
        System.out.println("Puntuaciones: Jugador 1: " + jugador1 + " | Jugador 2: " + jugador2);
    }

}
