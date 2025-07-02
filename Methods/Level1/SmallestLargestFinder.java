package Level1;

import java.util.Scanner;

public class SmallestLargestFinder {
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = Math.min(number1, Math.min(number2, number3));
        int largest = Math.max(number1, Math.max(number2, number3));
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int n1 = scn.nextInt();
        System.out.print("Enter second number: ");
        int n2 = scn.nextInt();
        System.out.print("Enter third number: ");
        int n3 = scn.nextInt();
        int[] result = findSmallestAndLargest(n1, n2, n3);
        System.out.println("Smallest: " + result[0] + ", Largest: " + result[1]);
    }
}
