package searches;
public class FirstNegativeLinearSearch {
    public static int findFirstNegativeIndex(int[] integerArray) {
        for (int index = 0; index < integerArray.length; index++) {
            if (integerArray[index] < 0) {
                return index;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] sampleArray = {3, 7, 0, -2, 5};
        int negativeIndex = findFirstNegativeIndex(sampleArray);
        System.out.println(negativeIndex);
    }
} 