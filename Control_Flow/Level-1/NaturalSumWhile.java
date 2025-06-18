import java.util.Scanner;

public class NaturalSumWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        
        if (number > 0) {
            int sumFormula = number * (number + 1) / 2;
            int sumWhile = 0;
            int i = 1;
            
            while (i <= number) {
                sumWhile += i;
                i++;
            }
            
            System.out.println("Formula result: " + sumFormula);
            System.out.println("While loop result: " + sumWhile);
            System.out.println("Results match: " + (sumFormula == sumWhile));
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
    }
} 