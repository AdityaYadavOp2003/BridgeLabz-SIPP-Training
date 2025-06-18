import java.util.Scanner;

public class NaturalSumFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        
        if (number > 0) {
            int sumFormula = number * (number + 1) / 2;
            int sumFor = 0;
            
            for (int i = 1; i <= number; i++) {
                sumFor += i;
            }
            
            System.out.println("Formula result: " + sumFormula);
            System.out.println("For loop result: " + sumFor);
            System.out.println("Results match: " + (sumFormula == sumFor));
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }
    }
} 