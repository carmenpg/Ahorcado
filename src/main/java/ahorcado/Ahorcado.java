/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ahorcado;

/**
 *
 * @author carmenperezgomez
 */


public class Ahorcado {

    private String palabraSecreta;
    private char[] progreso;
    private int errores;
    private static final int MAX_ERRORES = 6;

    public Ahorcado(String palabra) {
        this.palabraSecreta = palabra.toUpperCase();
        this.progreso = new char[palabraSecreta.length()];
        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }
        this.errores = 0;
    }

    public boolean adivinarLetra(char letra) {
        boolean acierto = false;

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                progreso[i] = letra;
                acierto = true;
            }
        }

        if (!acierto) {
            errores++;
        }

        return acierto;
    }

    public boolean estaAdivinada() {
        return String.valueOf(progreso).equals(palabraSecreta);
    }

    public boolean tieneErroresDisponibles() {
        return errores < MAX_ERRORES;
    }

    public String getProgreso() {
        return String.valueOf(progreso);
    }

    public int getErrores() {
        return errores;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }
}
