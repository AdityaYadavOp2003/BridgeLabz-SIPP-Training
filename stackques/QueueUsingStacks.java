package stackques;

public class QueueUsingStacks {
    private java.util.Stack<Integer> inputStack = new java.util.Stack<>();
    private java.util.Stack<Integer> outputStack = new java.util.Stack<>();

    public void enqueue(int value) {
        inputStack.push(value);
    }

    public int dequeue() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.isEmpty() ? -1 : outputStack.pop();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(40);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
} 