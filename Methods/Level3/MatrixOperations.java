package Level3;

import java.util.*;

public class MatrixOperations {
    public static int[][] randomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] m = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                m[i][j] = rand.nextInt(10) + 1;
        return m;
    }
    public static int[][] add(int[][] a, int[][] b) {
        int[][] r = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                r[i][j] = a[i][j] + b[i][j];
        return r;
    }
    public static int[][] subtract(int[][] a, int[][] b) {
        int[][] r = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                r[i][j] = a[i][j] - b[i][j];
        return r;
    }
    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] r = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < a[0].length; k++)
                    r[i][j] += a[i][k] * b[k][j];
        return r;
    }
    public static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter rows and cols for matrices: ");
        int r = scn.nextInt(), c = scn.nextInt();
        int[][] a = randomMatrix(r, c);
        int[][] b = randomMatrix(r, c);
        System.out.println("Matrix A:"); printMatrix(a);
        System.out.println("Matrix B:"); printMatrix(b);
        System.out.println("A+B:"); printMatrix(add(a, b));
        System.out.println("A-B:"); printMatrix(subtract(a, b));
        if (r == c) {
            System.out.println("A*B:"); printMatrix(multiply(a, b));
        } else {
            System.out.println("Multiplication only for square matrices.");
        }
    }
}
