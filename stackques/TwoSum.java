package stackques;
import java.util.HashMap;

public class TwoSum {
    public static int[] findTwoSumIndices(int[] inputArray, int targetSum) {
        HashMap<Integer, Integer> valueToIndexMap = new HashMap<>();
        for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++) {
            int requiredValue = targetSum - inputArray[currentIndex];
            if (valueToIndexMap.containsKey(requiredValue)) {
                return new int[]{valueToIndexMap.get(requiredValue), currentIndex};
            }
            valueToIndexMap.put(inputArray[currentIndex], currentIndex);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = findTwoSumIndices(numbers, target);
        if (result.length == 2) {
            System.out.println(result[0] + " " + result[1]);
        }
    }
} 