package Level2;

import java.util.*;

public class Quadratic {
    public static double[] findRoots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double r1 = (-b + Math.sqrt(delta)) / (2 * a);
            double r2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{r1, r2};
        } else if (delta == 0) {
            double r = -b / (2 * a);
            return new double[]{r};
        } else {
            return new double[0];
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = scn.nextDouble();
        System.out.print("Enter b: ");
        double b = scn.nextDouble();
        System.out.print("Enter c: ");
        double c = scn.nextDouble();
        double[] roots = findRoots(a, b, c);
        if (roots.length == 2) System.out.printf("Roots: %.2f, %.2f\n", roots[0], roots[1]);
        else if (roots.length == 1) System.out.printf("One root: %.2f\n", roots[0]);
        else System.out.println("No real roots");
    }
}
