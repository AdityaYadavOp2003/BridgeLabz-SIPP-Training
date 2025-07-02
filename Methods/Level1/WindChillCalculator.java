package Level1;

import java.util.Scanner;

public class WindChillCalculator {
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter temperature (F): ");
        double temp = scn.nextDouble();
        System.out.print("Enter wind speed (mph): ");
        double windSpeed = scn.nextDouble();
        double windChill = calculateWindChill(temp, windSpeed);
        System.out.printf("The wind chill temperature is %.2f\n", windChill);
    }
}
