package Level2;

import java.util.*;

public class SumNaturalNumbers {
    public static int sumRecursive(int n) {
        if (n <= 1) return n;
        return n + sumRecursive(n - 1);
    }
    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scn.nextInt();
        if (n < 1) {
            System.out.println("Not a natural number.");
            return;
        }
        int rec = sumRecursive(n);
        int form = sumFormula(n);
        System.out.println("Recursive sum: " + rec);
        System.out.println("Formula sum: " + form);
        System.out.println("Results match: " + (rec == form));
    }
}
