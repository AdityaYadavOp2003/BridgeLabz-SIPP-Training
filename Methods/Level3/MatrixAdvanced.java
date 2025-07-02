package Level3;

import java.util.*;

public class MatrixAdvanced {
    public static int[][] randomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] m = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                m[i][j] = rand.nextInt(10) + 1;
        return m;
    }
    public static int[][] transpose(int[][] m) {
        int[][] t = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                t[j][i] = m[i][j];
        return t;
    }
    public static int determinant2x2(int[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }
    public static int determinant3x3(int[][] m) {
        return m[0][0]*(m[1][1]*m[2][2]-m[1][2]*m[2][1]) - m[0][1]*(m[1][0]*m[2][2]-m[1][2]*m[2][0]) + m[0][2]*(m[1][0]*m[2][1]-m[1][1]*m[2][0]);
    }
    public static double[][] inverse2x2(int[][] m) {
        int det = determinant2x2(m);
        if (det == 0) return null;
        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1]/(double)det;
        inv[0][1] = -m[0][1]/(double)det;
        inv[1][0] = -m[1][0]/(double)det;
        inv[1][1] = m[0][0]/(double)det;
        return inv;
    }
    public static double[][] inverse3x3(int[][] m) {
        int det = determinant3x3(m);
        if (det == 0) return null;
        double[][] inv = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[][] minor = new int[2][2];
                int r = 0, c = 0;
                for (int k = 0; k < 3; k++) {
                    if (k == i) continue;
                    c = 0;
                    for (int l = 0; l < 3; l++) {
                        if (l == j) continue;
                        minor[r][c++] = m[k][l];
                    }
                    r++;
                }
                inv[j][i] = Math.pow(-1, i + j) * determinant2x2(minor) / (double)det;
            }
        }
        return inv;
    }
    public static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }
    }
    public static void printMatrix(double[][] m) {
        for (double[] row : m) {
            for (double v : row) System.out.printf("%.2f ", v);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size (2 or 3) for square matrix: ");
        int n = scn.nextInt();
        int[][] m = randomMatrix(n, n);
        System.out.println("Matrix:"); printMatrix(m);
        System.out.println("Transpose:"); printMatrix(transpose(m));
        if (n == 2) {
            System.out.println("Determinant: " + determinant2x2(m));
            double[][] inv = inverse2x2(m);
            if (inv != null) { System.out.println("Inverse:"); printMatrix(inv); }
            else System.out.println("No inverse (det=0)");
        } else if (n == 3) {
            System.out.println("Determinant: " + determinant3x3(m));
            double[][] inv = inverse3x3(m);
            if (inv != null) { System.out.println("Inverse:"); printMatrix(inv); }
            else System.out.println("No inverse (det=0)");
        }
    }
}
