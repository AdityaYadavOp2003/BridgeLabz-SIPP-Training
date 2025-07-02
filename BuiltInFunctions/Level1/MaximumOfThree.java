package Level1;

import java.util.Scanner;

public class MaximumOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = getInput(sc, "Enter first number: ");
        int b = getInput(sc, "Enter second number: ");
        int c = getInput(sc, "Enter third number: ");
        int max = findMax(a, b, c);
        System.out.println("Maximum is: " + max);
    }

    static int getInput(Scanner sc, String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    static int findMax(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }
}
