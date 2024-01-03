package ejercicioseimmerarmijos;
//Eimmer y Pablo
import java.util.Scanner;
public class Problema4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear el tablero de tres en raya (matriz 3x3)
        char[][] tablero = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        // Jugador actual (X o O)
        char jugadorActual = 'X';

        // Bandera para verificar si el juego ha terminado
        boolean juegoTerminado = false;

        // Bucle principal del juego
        while (!juegoTerminado) {
            // Mostrar el tablero
            mostrarTablero(tablero);

            // Obtener el movimiento del jugador actual
            System.out.println("Turno del jugador " + jugadorActual);
            System.out.print("Ingrese la fila (0-2): ");
            int fila = scanner.nextInt();
            System.out.print("Ingrese la columna (0-2): ");
            int columna = scanner.nextInt();

            // Verificar si la casilla está ocupada
            if (tablero[fila][columna] == ' ') {
                // Marcar la casilla con el símbolo del jugador actual
                tablero[fila][columna] = jugadorActual;

                // Verificar si el jugador actual ha ganado
                if (haGanado(tablero, jugadorActual)) {
                    mostrarTablero(tablero);
                    System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
                    juegoTerminado = true;
                }
            } else {
                System.out.println("Casilla ocupada. Intente de nuevo.");
            }
        }
    }

    // Método para mostrar el tablero
    private static void mostrarTablero(char[][] tablero) {
        System.out.println("=== Tablero ===");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
                if (j < tablero[i].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < tablero.length - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    // Método para verificar si un jugador ha ganado
    private static boolean haGanado(char[][] tablero, char jugador) {
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if ((tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) ||
                (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador)) {
                return true;
            }
        }

        // Verificar diagonales
        if ((tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) ||
            (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador)) {
            return true;
        }

        return false;
    }
}