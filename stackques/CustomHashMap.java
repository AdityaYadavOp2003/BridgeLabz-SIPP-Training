package stackques;

class Node {
    int key;
    int value;
    Node next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomHashMap {
    private Node[] bucketArray;
    private int capacity;

    public CustomHashMap() {
        capacity = 16;
        bucketArray = new Node[capacity];
    }

    private int getBucketIndex(int key) {
        return Integer.hashCode(key) % capacity;
    }

    public void put(int key, int value) {
        int bucketIndex = getBucketIndex(key);
        Node head = bucketArray[bucketIndex];
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = head;
        bucketArray[bucketIndex] = newNode;
    }

    public Integer get(int key) {
        int bucketIndex = getBucketIndex(key);
        Node current = bucketArray[bucketIndex];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);
        Node current = bucketArray[bucketIndex];
        Node previous = null;
        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    bucketArray[bucketIndex] = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        map.put(2, 20);
        map.put(1, 15);
        System.out.println(map.get(1));
        map.remove(1);
        System.out.println(map.get(1));
    }
} 