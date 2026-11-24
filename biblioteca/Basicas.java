package biblioteca;

import java.util.Scanner;

public class Basicas {

    // Función que pide matriz de enteros al usuario y la devuelve
    public static int[][] fillFromkeyboard(int rows, int cols, Scanner sc) {
        int[][] array = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Ingrese el elemento [" + i + "][" + j + "]: ");
                array[i][j] = Integer.parseInt(sc.nextLine());
            }
        }

        return array;
    }

    // Función que imprime matriz de enteros
    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // Función que devuelve la transpuesta de una matriz
    public static int[][] transpuesta(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] resultado = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[j][i] = matriz[i][j];
            }
        }

        return resultado;
    }

    // Función que devuelve la traza de una matriz cuadrada de enteros
    public static int trace(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        if (rows != cols) {
            throw new IllegalArgumentException("La matriz debe ser cuadrada para calcular la traza");
        }
        int trace = 0;
        for (int i = 0; i < rows; i++) {
            trace += array[i][i];
        }
        return trace;
    }

    // Función que devuelve un booleano indicando si la matriz es simétrica o no
    public static boolean esSimetrica(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        if (filas != columnas) {
            return false;
        }

        for (int i = 0; i < filas; i++) {
            for (int j = i + 1; j < columnas; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean esMatrizDiagonal(int[][] matriz) {
        int filas = matriz.length;
        if (filas == 0)
            return false;
        int columnas = matriz[0].length;

        if (filas != columnas) {
            return false;
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i != j && matriz[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    // Método que calcula la matriz suma de dos matrices de enteros
    public static int[][] sumaMatrices(int[][] matriz1, int[][] matriz2) {
        int filas1 = matriz1.length;
        int columnas1 = matriz1[0].length;
        int filas2 = matriz2.length;
        int columnas2 = matriz2[0].length;

        if (filas1 != filas2 || columnas1 != columnas2) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones para sumarlas.");
        }

        int[][] resultado = new int[filas1][columnas1];

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas1; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return resultado;
    }

    // Método que resta dos matrices de enteros
    public static int[][] restaMatrices(int[][] matriz1, int[][] matriz2) {
        int filas1 = matriz1.length;
        int columnas1 = matriz1[0].length;
        int filas2 = matriz2.length;
        int columnas2 = matriz2[0].length;

        if (filas1 != filas2 || columnas1 != columnas2) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones para restarlas.");
        }

        int[][] resultado = new int[filas1][columnas1];

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas1; j++) {
                resultado[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }

        return resultado;
    }

    // Método que multiplica dos matrices de enteros
    public static int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2) {
        int filas1 = matriz1.length;
        int columnas1 = matriz1[0].length;
        int filas2 = matriz2.length;
        int columnas2 = matriz2[0].length;

        if (columnas1 != filas2) {
            throw new IllegalArgumentException(
                    "El número de columnas de la primera matriz debe coincidir con el número de filas de la segunda.");
        }

        int[][] resultado = new int[filas1][columnas2];

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas2; j++) {
                for (int k = 0; k < columnas1; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        return resultado;
    }

    // Función que calcula el determinante de una matriz cuadrada de enteros
    public static int determinant(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        if (rows != cols) {
            throw new IllegalArgumentException("la matriz debe ser cuadrada");
        }
        if (rows == 1) {
            return array[0][0];
        }
        if (rows == 2) {
            return array[0][0] * array[1][1] - array[0][1] * array[1][0];
        }
        int determinant = 0;
        for (int j = 0; j < cols; j++) {
            determinant += Math.pow(-1, j) * array[0][j] * determinant(minor(array, 0, j));
        }
        return determinant;
    }

    public static int[][] minor(int[][] array, int row, int col) {
        int rows = array.length;
        int cols = array[0].length;
        int[][] minor = new int[rows - 1][cols - 1];

        int mi = 0;
        for (int i = 0; i < rows; i++) {
            if (i == row)
                continue;

            int mj = 0;
            for (int j = 0; j < cols; j++) {
                if (j == col)
                    continue;
                minor[mi][mj] = array[i][j];
                mj++;
            }
            mi++;
        }

        return minor;
    }

    // Cálculo de la matriz adjunta de una matriz de enteros
    public static int[][] calcularAdjunta(int[][] matriz) {
        int n = matriz.length;
        int[][] adjunta = new int[n][n];
        if (n == 1) {
            adjunta[0][0] = 1;
            return adjunta;
        }

        int signo = 1;
        int[][] temp = new int[n - 1][n - 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                obtenerCofactor(matriz, temp, i, j, n);
                signo = ((i + j) % 2 == 0) ? 1 : -1;
                // CORREGIDO: determinant en lugar de determinante
                adjunta[j][i] = signo * determinant(temp);
            }
        }
        return adjunta;
    }

    private static void obtenerCofactor(int[][] matriz, int[][] temp, int p, int q, int n) {
        int i = 0, j = 0;

        for (int fila = 0; fila < n; fila++) {
            for (int col = 0; col < n; col++) {
                if (fila != p && col != q) {
                    temp[i][j++] = matriz[fila][col];

                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    // Matriz inversa
    public static double[][] inversa(int[][] m) {
        // CORREGIDO: determinant en lugar de determinante
        int det = determinant(m);

        if (det == 0) {
            return null;
        }

        int n = m.length;
        int[][] adj = calcularAdjunta(m);
        double[][] inv = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inv[i][j] = (double) adj[i][j] / det;
            }
        }

        return inv;
    }

    // matriz indetidad
    public static int[][] generarMatrizIdentidad(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("El tamaño de la matriz debe ser mayor que 0.");
        }
        int[][] matriz = new int[n][n];
        // Solo hace falta recorrer la diagonal principal
        for (int i = 0; i < n; i++) {
            matriz[i][i] = 1;
        }
        return matriz;
    }

    // matriz identidad con doubles
    public static double[][] generarMatrizIdentidadDouble(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("El tamaño de la matriz debe ser mayor que 0.");
        }
        double[][] matriz = new double[n][n];
        for (int i = 0; i < n; i++) {
            matriz[i][i] = 1.0;
        }
        return matriz;
    }

    // Método que resuelve el sistema Ax = b usando la matriz inversa
    public static double[] solveLinearSystem(int[][] A, int[] b) {
        int rows = A.length;
        int cols = A[0].length;
        if (rows != cols) {
            throw new IllegalArgumentException("La matriz A debe ser cuadrada para resolver el sistema.");
        }
        if (b.length != rows) {
            throw new IllegalArgumentException("El vector b debe tener el mismo número de filas que la matriz A.");
        }
        double[][] A_inv = inversa(A);
        double[] x = new double[rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                x[i] += A_inv[i][j] * b[j];
            }
        }
        return x;
    }
}