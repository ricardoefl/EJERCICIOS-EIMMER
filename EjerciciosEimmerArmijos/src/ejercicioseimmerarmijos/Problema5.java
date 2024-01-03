package ejercicioseimmerarmijos;
//Eimmer y Pablo
import java.util.Scanner;
import java.util.Random;
public class Problema5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Ingresar dimensiones de la primera matriz
        System.out.print("Ingrese el número de filas de la primera matriz: ");
        int filasMatriz1 = scanner.nextInt();
        System.out.print("Ingrese el número de columnas de la primera matriz: ");
        int columnasMatriz1 = scanner.nextInt();

        // Ingresar dimensiones de la segunda matriz
        System.out.print("Ingrese el número de filas de la segunda matriz: ");
        int filasMatriz2 = scanner.nextInt();
        System.out.print("Ingrese el número de columnas de la segunda matriz: ");
        int columnasMatriz2 = scanner.nextInt();

        // Verificar si se pueden multiplicar las matrices
        if (columnasMatriz1 != filasMatriz2) {
            System.out.println("No se pueden multiplicar las matrices. Las dimensiones no son compatibles.");
            return;
        }

        // Crear las matrices con números aleatorios únicos
        int[][] matriz1 = new int[filasMatriz1][columnasMatriz1];
        int[][] matriz2 = new int[filasMatriz2][columnasMatriz2];

        for (int i = 0; i < filasMatriz1; i++) {
            for (int j = 0; j < columnasMatriz1; j++) {
                matriz1[i][j] = random.nextInt(19) - 9;
            }
        }

        for (int i = 0; i < filasMatriz2; i++) {
            for (int j = 0; j < columnasMatriz2; j++) {
                matriz2[i][j] = random.nextInt(19) - 9;
            }
        }

        // Mostrar la primera matriz
        System.out.println("\nPrimera Matriz:");
        for (int i = 0; i < filasMatriz1; i++) {
            for (int j = 0; j < columnasMatriz1; j++) {
                System.out.print(matriz1[i][j] + "\t");
            }
            System.out.println();
        }

        // Mostrar la segunda matriz
        System.out.println("\nSegunda Matriz:");
        for (int i = 0; i < filasMatriz2; i++) {
            for (int j = 0; j < columnasMatriz2; j++) {
                System.out.print(matriz2[i][j] + "\t");
            }
            System.out.println();
        }

        // Realizar la multiplicación de las matrices
        int[][] resultado = new int[filasMatriz1][columnasMatriz2];

        for (int i = 0; i < filasMatriz1; i++) {
            for (int j = 0; j < columnasMatriz2; j++) {
                resultado[i][j] = 0;

                for (int k = 0; k < columnasMatriz1; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        // Mostrar el resultado
        System.out.println("\nResultado de la Multiplicación:");
        for (int i = 0; i < filasMatriz1; i++) {
            for (int j = 0; j < columnasMatriz1; j++) {
                System.out.print(resultado[i][j] + "\t");
            }
            System.out.println();
        }
    }
}