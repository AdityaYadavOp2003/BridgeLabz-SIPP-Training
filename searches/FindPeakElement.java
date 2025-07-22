package searches;
public class FindPeakElement {
    public static int findPeakIndex(int[] numberArray) {
        int leftIndex = 0;
        int rightIndex = numberArray.length - 1;
        while (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (numberArray[middleIndex] < numberArray[middleIndex + 1]) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex;
            }
        }
        return leftIndex;
    }
    public static void main(String[] args) {
        int[] sampleNumbers = {1, 3, 20, 4, 1, 0};
        int peakIndex = findPeakIndex(sampleNumbers);
        System.out.println(peakIndex);
    }
} 