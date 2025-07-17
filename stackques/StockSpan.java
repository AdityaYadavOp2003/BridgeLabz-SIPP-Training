import java.util.Stack;

public class StockSpan {
    public static int[] calculateSpan(int[] priceArray) {
        int numberOfDays = priceArray.length;
        int[] spanArray = new int[numberOfDays];
        Stack<Integer> indexStack = new Stack<>();
        for (int currentDay = 0; currentDay < numberOfDays; currentDay++) {
            while (!indexStack.isEmpty() && priceArray[currentDay] >= priceArray[indexStack.peek()]) {
                indexStack.pop();
            }
            spanArray[currentDay] = indexStack.isEmpty() ? (currentDay + 1) : (currentDay - indexStack.peek());
            indexStack.push(currentDay);
        }
        return spanArray;
    }

    public static void main(String[] args) {
        int[] stockPrices = {100, 80, 60, 70, 60, 75, 85};
        int[] spanResult = calculateSpan(stockPrices);
        for (int span : spanResult) {
            System.out.print(span + " ");
        }
    }
} 