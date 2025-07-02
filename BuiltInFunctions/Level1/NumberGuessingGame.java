package Level1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int low = 1, high = 100;
        System.out.println("Think of a number between 1 and 100. I will try to guess it!");
        while (true) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct')");
            String feedback = sc.next();
            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Yay! I guessed your number.");
                break;
            } else if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            } else if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            }
        }
    }

    static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }
}
