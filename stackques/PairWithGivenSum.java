package stackques;
import java.util.HashSet;

public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] inputArray, int targetSum) {
        HashSet<Integer> visitedNumbers = new HashSet<>();
        for (int currentNumber : inputArray) {
            int requiredNumber = targetSum - currentNumber;
            if (visitedNumbers.contains(requiredNumber)) {
                return true;
            }
            visitedNumbers.add(currentNumber);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {8, 7, 2, 5, 3, 1};
        int target = 10;
        System.out.println(hasPairWithSum(numbers, target));
    }
} 