package stackQues;

import java.util.Stack;

public class SortStackRecursively {
    public static void sortStack(Stack<Integer> stackToSort) {
        if (!stackToSort.isEmpty()) {
            int topElement = stackToSort.pop();
            sortStack(stackToSort);
            insertInSortedOrder(stackToSort, topElement);
        }
    }

    private static void insertInSortedOrder(Stack<Integer> sortedStack, int value) {
        if (sortedStack.isEmpty() || value > sortedStack.peek()) {
            sortedStack.push(value);
        } else {
            int removedElement = sortedStack.pop();
            insertInSortedOrder(sortedStack, value);
            sortedStack.push(removedElement);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stackOfNumbers = new Stack<>();
        stackOfNumbers.push(3);
        stackOfNumbers.push(1);
        stackOfNumbers.push(4);
        stackOfNumbers.push(2);
        sortStack(stackOfNumbers);
        while (!stackOfNumbers.isEmpty()) {
            System.out.println(stackOfNumbers.pop());
        }
    }
} 