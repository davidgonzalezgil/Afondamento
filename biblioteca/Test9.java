package biblioteca;

import static biblioteca.Basicas.*;
import java.util.Scanner;

public class Test9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el número de filas de la matriz: ");
        int rows = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el número de columnas de la matriz: ");
        int cols = Integer.parseInt(sc.nextLine());
        int[][] matriz = fillFromkeyboard(rows, cols, sc);

        System.out.println("\nMatriz:");
        print2DArray(matriz);

        double[][] inv = inversa(matriz);

        System.out.println("\nMatriz inversa: ");
        if (inv != null) {
            for (double[] row : inv) {
                for (double elemento : row) {
                    System.out.print(elemento + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("La matriz no tiene inversa (determinante = 0).");
        }
    }
}