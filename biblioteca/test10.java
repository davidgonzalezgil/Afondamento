package biblioteca;

import static biblioteca.Basicas.*;
import java.util.Scanner;

public class test10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("2x2:");
        int[][] A = fillFromkeyboard(2, 2, sc);

        System.out.println("terminos independientes:");
        int[] b = new int[2];
        for (int i = 0; i < 2; i++) {
            System.out.print("Imete elemento [" + i + "] ");
            b[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.println("matriz A:");
        print2DArray(A);

        double[] X = solveLinearSystem(A, b);

        System.out.println("Solucion");
        System.out.println("x = " + X[0]);
        System.out.println("y = " + X[1]);

        sc.close();
    }
}