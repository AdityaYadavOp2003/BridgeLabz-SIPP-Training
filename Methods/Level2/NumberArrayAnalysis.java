package Level2;

import java.util.*;

public class NumberArrayAnalysis {
    public static boolean isPositive(int n) { return n > 0; }
    public static boolean isEven(int n) { return n % 2 == 0; }
    public static int compare(int a, int b) { return Integer.compare(a, b); }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i+1) + ": ");
            arr[i] = scn.nextInt();
        }
        for (int n : arr) {
            if (isPositive(n)) {
                System.out.print(n + " is positive and ");
                System.out.println(isEven(n) ? "even" : "odd");
            } else {
                System.out.println(n + " is negative");
            }
        }
        int cmp = compare(arr[0], arr[4]);
        if (cmp == 0) System.out.println("First and last elements are equal");
        else if (cmp > 0) System.out.println("First element is greater than last");
        else System.out.println("First element is less than last");
    }
}
