package Level1;

import java.util.Scanner;

public class AthleteRounds {
    public static double calculateRounds(double side1, double side2, double side3, double distance) {
        double perimeter = side1 + side2 + side3;
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter side 1 (meters): ");
        double side1 = scn.nextDouble();
        System.out.print("Enter side 2 (meters): ");
        double side2 = scn.nextDouble();
        System.out.print("Enter side 3 (meters): ");
        double side3 = scn.nextDouble();
        double distance = 5000.0; // 5 km in meters
        double rounds = calculateRounds(side1, side2, side3, distance);
        System.out.printf("The athlete must complete %.2f rounds to run 5 km.\n", rounds);
    }
}
