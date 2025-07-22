package searches;
public class FindRotationPoint {
    public static int findRotationIndex(int[] rotatedArray) {
        int leftIndex = 0;
        int rightIndex = rotatedArray.length - 1;
        while (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (rotatedArray[middleIndex] > rotatedArray[rightIndex]) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex;
            }
        }
        return leftIndex;
    }
    public static void main(String[] args) {
        int[] rotatedSample = {4, 5, 6, 7, 0, 1, 2};
        int rotationIndex = findRotationIndex(rotatedSample);
        System.out.println(rotationIndex);
    }
} 