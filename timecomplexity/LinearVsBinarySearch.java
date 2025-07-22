package timecomplexity;
import java.util.Arrays;
public class LinearVsBinarySearch {
    public static void main(String[] args) {
        int[] dataset = new int[1000000];
        for (int index = 0; index < dataset.length; index++) {
            dataset[index] = index * 2;
        }
        int searchTarget = 123456;
        long linearStartTime = System.nanoTime();
        int linearResult = linearSearch(dataset, searchTarget);
        long linearEndTime = System.nanoTime();
        long linearDuration = linearEndTime - linearStartTime;
        Arrays.sort(dataset);
        long binaryStartTime = System.nanoTime();
        int binaryResult = binarySearch(dataset, searchTarget);
        long binaryEndTime = System.nanoTime();
        long binaryDuration = binaryEndTime - binaryStartTime;
        System.out.println("Linear Search Index: " + linearResult + ", Time: " + linearDuration + " ns");
        System.out.println("Binary Search Index: " + binaryResult + ", Time: " + binaryDuration + " ns");
    }
    static int linearSearch(int[] inputArray, int searchValue) {
        for (int position = 0; position < inputArray.length; position++) {
            if (inputArray[position] == searchValue) {
                return position;
            }
        }
        return -1;
    }
    static int binarySearch(int[] sortedArray, int searchValue) {
        int leftBoundary = 0;
        int rightBoundary = sortedArray.length - 1;
        while (leftBoundary <= rightBoundary) {
            int middleIndex = leftBoundary + (rightBoundary - leftBoundary) / 2;
            if (sortedArray[middleIndex] == searchValue) {
                return middleIndex;
            }
            if (sortedArray[middleIndex] < searchValue) {
                leftBoundary = middleIndex + 1;
            } else {
                rightBoundary = middleIndex - 1;
            }
        }
        return -1;
    }
} 