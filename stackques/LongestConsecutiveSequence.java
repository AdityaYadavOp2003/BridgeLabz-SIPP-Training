package stackques;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int findLongestConsecutiveSequence(int[] inputArray) {
        HashSet<Integer> numberSet = new HashSet<>();
        for (int number : inputArray) {
            numberSet.add(number);
        }
        int longestStreak = 0;
        for (int number : inputArray) {
            if (!numberSet.contains(number - 1)) {
                int currentNumber = number;
                int currentStreak = 1;
                while (numberSet.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentStreak++;
                }
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] numbers = {100, 4, 200, 1, 3, 2};
        System.out.println(findLongestConsecutiveSequence(numbers));
    }
} 