package biblioteca;

import static biblioteca.Basicas.*;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("dame numero filas");
        int rows = Integer.parseInt(sc.nextLine());
        System.out.println("dame numero columnas");
        int cols = Integer.parseInt(sc.nextLine());

        int[][] matriz = fillFromkeyboard(rows, cols, sc);

        System.out.println("matriz:");
        print2DArray(matriz);
    }
}