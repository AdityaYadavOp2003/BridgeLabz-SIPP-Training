package Level1;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        System.out.print("Choose operation (+, -, *, /): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+':
                System.out.println("Result: " + add(a, b)); break;
            case '-':
                System.out.println("Result: " + subtract(a, b)); break;
            case '*':
                System.out.println("Result: " + multiply(a, b)); break;
            case '/':
                System.out.println("Result: " + divide(a, b)); break;
            default:
                System.out.println("Invalid operation");
        }
    }

    static double add(double x, double y) {
        return x + y;
    }

    static double subtract(double x, double y) {
        return x - y;
    }

    static double multiply(double x, double y) {
        return x * y;
    }

    static double divide(double x, double y) {
        if (y == 0) return Double.NaN;
        return x / y;
    }
}
