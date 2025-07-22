package searches;
import java.util.Arrays;
public class LinearBinarySearchChallenge {
    public static int findFirstMissingPositive(int[] numberList) {
        int n = numberList.length;
        for (int i = 0; i < n; i++) {
            while (numberList[i] > 0 && numberList[i] <= n && numberList[numberList[i] - 1] != numberList[i]) {
                int temp = numberList[numberList[i] - 1];
                numberList[numberList[i] - 1] = numberList[i];
                numberList[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (numberList[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
    public static int binarySearchIndex(int[] sortedList, int targetValue) {
        int leftIndex = 0;
        int rightIndex = sortedList.length - 1;
        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (sortedList[middleIndex] == targetValue) return middleIndex;
            if (sortedList[middleIndex] < targetValue) leftIndex = middleIndex + 1;
            else rightIndex = middleIndex - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] inputNumbers = {3, 4, -1, 1};
        int missingPositive = findFirstMissingPositive(Arrays.copyOf(inputNumbers, inputNumbers.length));
        Arrays.sort(inputNumbers);
        int targetIndex = binarySearchIndex(inputNumbers, 4);
        System.out.println(missingPositive + " " + targetIndex);
    }
} 