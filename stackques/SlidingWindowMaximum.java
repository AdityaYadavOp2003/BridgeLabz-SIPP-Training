package stackques;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static int[] findMaximumInWindows(int[] inputArray, int windowSize) {
        if (inputArray == null || windowSize <= 0) {
            return new int[0];
        }
        int arrayLength = inputArray.length;
        int[] maximumValues = new int[arrayLength - windowSize + 1];
        Deque<Integer> indexDeque = new LinkedList<>();
        for (int currentIndex = 0; currentIndex < arrayLength; currentIndex++) {
            while (!indexDeque.isEmpty() && indexDeque.peek() < currentIndex - windowSize + 1) {
                indexDeque.poll();
            }
            while (!indexDeque.isEmpty() && inputArray[currentIndex] >= inputArray[indexDeque.peekLast()]) {
                indexDeque.pollLast();
            }
            indexDeque.offer(currentIndex);
            if (currentIndex >= windowSize - 1) {
                maximumValues[currentIndex - windowSize + 1] = inputArray[indexDeque.peek()];
            }
        }
        return maximumValues;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, -1, -3, 5, 3, 6, 7};
        int window = 3;
        int[] result = findMaximumInWindows(numbers, window);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
} 