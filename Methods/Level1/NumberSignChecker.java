package Level1;

import java.util.Scanner;

public class NumberSignChecker {
    public static int checkNumberSign(int number) {
        if (number > 0) return 1;
        else if (number < 0) return -1;
        else return 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scn.nextInt();
        int result = checkNumberSign(number);
        if (result == 1) System.out.println("The number is positive.");
        else if (result == -1) System.out.println("The number is negative.");
        else System.out.println("The number is zero.");
    }
}
