import java.util.Scanner;

public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        System.out.println("The Quotient is " + (n1 / n2) + " and Reminder is " + (n1 % n2) + " of two number " + n1 + " and " + n2);
    }
} 