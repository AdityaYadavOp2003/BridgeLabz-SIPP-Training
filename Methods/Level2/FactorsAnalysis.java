package Level2;

import java.util.*;

public class FactorsAnalysis {
    public static int[] getFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) factors[idx++] = i;
        return factors;
    }
    public static int sum(int[] arr) {
        int s = 0; for (int x : arr) s += x; return s;
    }
    public static int product(int[] arr) {
        int p = 1; for (int x : arr) p *= x; return p;
    }
    public static int sumSquares(int[] arr) {
        int s = 0; for (int x : arr) s += Math.pow(x, 2); return s;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scn.nextInt();
        int[] factors = getFactors(n);
        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Sum: " + sum(factors));
        System.out.println("Sum of squares: " + sumSquares(factors));
        System.out.println("Product: " + product(factors));
    }
}
