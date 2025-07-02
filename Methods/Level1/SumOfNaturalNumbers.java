package Level1;

import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static int sumOfN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        int sum = sumOfN(n);
        System.out.println("Sum of first " + n + " natural numbers is: " + sum);
    }
}
