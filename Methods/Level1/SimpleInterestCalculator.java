package Level1;

import java.util.Scanner;

public class SimpleInterestCalculator {
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return principal * rate * time / 100;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Principal: ");
        double principal = scn.nextDouble();
        System.out.print("Enter Rate of Interest: ");
        double rate = scn.nextDouble();
        System.out.print("Enter Time (in years): ");
        double time = scn.nextDouble();
        double si = calculateSimpleInterest(principal, rate, time);
        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f\n", si, principal, rate, time);
    }
}
