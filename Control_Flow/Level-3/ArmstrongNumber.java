import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int originalNumber = number;
        int sum = 0;
        
        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            sum += Math.pow(digit, 3);
            originalNumber /= 10;
        }
        
        if (number == sum) {
            System.out.println(number + " is an Armstrong number");
        } else {
            System.out.println(number + " is not an Armstrong number");
        }
    }
} 