package sorting_algos;

public class MergeSortBookPrices {
    public static void sortBookPrices(int[] bookPrices) {
        if (bookPrices.length < 2) {
            return;
        }
        int middleIndex = bookPrices.length / 2;
        int[] leftHalf = new int[middleIndex];
        int[] rightHalf = new int[bookPrices.length - middleIndex];
        for (int i = 0; i < middleIndex; i++) {
            leftHalf[i] = bookPrices[i];
        }
        for (int i = middleIndex; i < bookPrices.length; i++) {
            rightHalf[i - middleIndex] = bookPrices[i];
        }
        sortBookPrices(leftHalf);
        sortBookPrices(rightHalf);
        merge(bookPrices, leftHalf, rightHalf);
    }
    private static void merge(int[] bookPrices, int[] leftHalf, int[] rightHalf) {
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;
        while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
            if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
                bookPrices[mergedIndex++] = leftHalf[leftIndex++];
            } else {
                bookPrices[mergedIndex++] = rightHalf[rightIndex++];
            }
        }
        while (leftIndex < leftHalf.length) {
            bookPrices[mergedIndex++] = leftHalf[leftIndex++];
        }
        while (rightIndex < rightHalf.length) {
            bookPrices[mergedIndex++] = rightHalf[rightIndex++];
        }
    }
    public static void main(String[] args) {
        int[] prices = {350, 200, 400, 150, 300};
        sortBookPrices(prices);
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }
} 