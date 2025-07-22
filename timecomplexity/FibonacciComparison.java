package timecomplexity;

public class FibonacciComparison {
    public static void main(String[] args) {
        int fibonacciIndex = 30;
        long recursiveStartTime = System.nanoTime();
        int recursiveResult = recursiveFibonacci(fibonacciIndex);
        long recursiveEndTime = System.nanoTime();
        long recursiveDuration = recursiveEndTime - recursiveStartTime;
        long iterativeStartTime = System.nanoTime();
        int iterativeResult = iterativeFibonacci(fibonacciIndex);
        long iterativeEndTime = System.nanoTime();
        long iterativeDuration = iterativeEndTime - iterativeStartTime;
        System.out.println("Recursive Fibonacci: " + recursiveResult + ", Time: " + recursiveDuration + " ns");
        System.out.println("Iterative Fibonacci: " + iterativeResult + ", Time: " + iterativeDuration + " ns");
    }
    static int recursiveFibonacci(int position) {
        if (position <= 1) return position;
        return recursiveFibonacci(position - 1) + recursiveFibonacci(position - 2);
    }
    static int iterativeFibonacci(int position) {
        if (position <= 1) return position;
        int previousValue = 0, currentValue = 1, nextValue;
        for (int index = 2; index <= position; index++) {
            nextValue = previousValue + currentValue;
            previousValue = currentValue;
            currentValue = nextValue;
        }
        return currentValue;
    }
} 