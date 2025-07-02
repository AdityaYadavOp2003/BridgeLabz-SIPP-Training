package Level3;

import java.util.*;

public class FactorsTasks {
    public static int[] getFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) factors[idx++] = i;
        return factors;
    }
    public static int greatestFactor(int[] f) {
        int max = f[0];
        for (int x : f) if (x > max) max = x;
        return max;
    }
    public static int sumFactors(int[] f) {
        int sum = 0; for (int x : f) sum += x; return sum;
    }
    public static int productFactors(int[] f) {
        int prod = 1; for (int x : f) prod *= x; return prod;
    }
    public static double productCubeFactors(int[] f) {
        double prod = 1; for (int x : f) prod *= Math.pow(x, 3); return prod;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scn.nextInt();
        int[] factors = getFactors(n);
        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Greatest factor: " + greatestFactor(factors));
        System.out.println("Sum of factors: " + sumFactors(factors));
        System.out.println("Product of factors: " + productFactors(factors));
        System.out.println("Product of cubes of factors: " + productCubeFactors(factors));
    }
}
