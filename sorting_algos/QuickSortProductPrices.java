package sorting_algos;

public class QuickSortProductPrices {
    public static void sortProductPrices(int[] productPrices, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partitionIndex = partition(productPrices, startIndex, endIndex);
            sortProductPrices(productPrices, startIndex, partitionIndex - 1);
            sortProductPrices(productPrices, partitionIndex + 1, endIndex);
        }
    }
    private static int partition(int[] productPrices, int startIndex, int endIndex) {
        int pivotValue = productPrices[endIndex];
        int smallerElementIndex = startIndex - 1;
        for (int currentIndex = startIndex; currentIndex < endIndex; currentIndex++) {
            if (productPrices[currentIndex] <= pivotValue) {
                smallerElementIndex++;
                int temp = productPrices[smallerElementIndex];
                productPrices[smallerElementIndex] = productPrices[currentIndex];
                productPrices[currentIndex] = temp;
            }
        }
        int temp = productPrices[smallerElementIndex + 1];
        productPrices[smallerElementIndex + 1] = productPrices[endIndex];
        productPrices[endIndex] = temp;
        return smallerElementIndex + 1;
    }
    public static void main(String[] args) {
        int[] prices = {1200, 800, 1500, 700, 1000};
        sortProductPrices(prices, 0, prices.length - 1);
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }
} 