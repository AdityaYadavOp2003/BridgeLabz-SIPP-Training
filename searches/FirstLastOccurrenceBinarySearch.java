package searches;
public class FirstLastOccurrenceBinarySearch {
    public static int findFirstOccurrence(int[] sortedArray, int targetValue) {
        int leftIndex = 0;
        int rightIndex = sortedArray.length - 1;
        int resultIndex = -1;
        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (sortedArray[middleIndex] == targetValue) {
                resultIndex = middleIndex;
                rightIndex = middleIndex - 1;
            } else if (sortedArray[middleIndex] < targetValue) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        return resultIndex;
    }
    public static int findLastOccurrence(int[] sortedArray, int targetValue) {
        int leftIndex = 0;
        int rightIndex = sortedArray.length - 1;
        int resultIndex = -1;
        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (sortedArray[middleIndex] == targetValue) {
                resultIndex = middleIndex;
                leftIndex = middleIndex + 1;
            } else if (sortedArray[middleIndex] < targetValue) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        return resultIndex;
    }
    public static void main(String[] args) {
        int[] sortedNumbers = {2, 4, 4, 4, 8, 10};
        int firstIndex = findFirstOccurrence(sortedNumbers, 4);
        int lastIndex = findLastOccurrence(sortedNumbers, 4);
        System.out.println(firstIndex + " " + lastIndex);
    }
} 