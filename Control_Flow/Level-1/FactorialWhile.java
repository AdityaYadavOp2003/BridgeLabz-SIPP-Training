import java.util.Scanner;

public class FactorialWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        
        if (number > 0) {
            int factorial = 1;
            int i = 1;
            
            while (i <= number) {
                factorial *= i;
                i++;
            }
            
            System.out.println("Factorial of " + number + " is " + factorial);
        } else {
            System.out.println("Please enter a positive integer");
        }
    }
} 