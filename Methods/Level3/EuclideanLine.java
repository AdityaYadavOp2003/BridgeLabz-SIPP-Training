package Level3;

import java.util.*;

public class EuclideanLine {
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    public static double[] lineEquation(int x1, int y1, int x2, int y2) {
        double m = (double)(y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return new double[]{m, b};
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter x1 y1: ");
        int x1 = scn.nextInt(), y1 = scn.nextInt();
        System.out.print("Enter x2 y2: ");
        int x2 = scn.nextInt(), y2 = scn.nextInt();
        System.out.printf("Euclidean distance: %.2f\n", distance(x1, y1, x2, y2));
        double[] eq = lineEquation(x1, y1, x2, y2);
        System.out.printf("Line: y = %.2fx + %.2f\n", eq[0], eq[1]);
    }
}
