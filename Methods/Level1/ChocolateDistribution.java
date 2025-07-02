package Level1;

import java.util.Scanner;

public class ChocolateDistribution {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{remainder, quotient};
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = scn.nextInt();
        System.out.print("Enter number of children: ");
        int numberOfChildren = scn.nextInt();
        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
        System.out.println("Each child gets: " + result[1] + ", Remaining chocolates: " + result[0]);
    }
}
