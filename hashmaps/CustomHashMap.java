package hashmaps;
import java.util.*;

class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;
    
    HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class CustomHashMap<K, V> {
    private HashNode<K, V>[] buckets;
    private int capacity;
    private int size;
    private static final double LOAD_FACTOR = 0.75;
    
    @SuppressWarnings("unchecked")
    public CustomHashMap(int initialCapacity) {
        this.capacity = initialCapacity;
        this.buckets = new HashNode[capacity];
        this.size = 0;
    }
    
    public CustomHashMap() {
        this(16);
    }
    
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }
    
    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        
        if ((double) size / capacity >= LOAD_FACTOR) {
            resize();
        }
        
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = buckets[bucketIndex];
        
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = buckets[bucketIndex];
        buckets[bucketIndex] = newNode;
        size++;
    }
    
    public V get(K key) {
        if (key == null) {
            return null;
        }
        
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = buckets[bucketIndex];
        
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        
        return null;
    }
    
    public V remove(K key) {
        if (key == null) {
            return null;
        }
        
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = buckets[bucketIndex];
        HashNode<K, V> previous = null;
        
        while (head != null) {
            if (head.key.equals(key)) {
                if (previous == null) {
                    buckets[bucketIndex] = head.next;
                } else {
                    previous.next = head.next;
                }
                size--;
                return head.value;
            }
            previous = head;
            head = head.next;
        }
        
        return null;
    }
    
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    
    public boolean containsValue(V value) {
        for (HashNode<K, V> bucket : buckets) {
            HashNode<K, V> current = bucket;
            while (current != null) {
                if (Objects.equals(current.value, value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void clear() {
        Arrays.fill(buckets, null);
        size = 0;
    }
    
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (HashNode<K, V> bucket : buckets) {
            HashNode<K, V> current = bucket;
            while (current != null) {
                keys.add(current.key);
                current = current.next;
            }
        }
        return keys;
    }
    
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        for (HashNode<K, V> bucket : buckets) {
            HashNode<K, V> current = bucket;
            while (current != null) {
                values.add(current.value);
                current = current.next;
            }
        }
        return values;
    }
    
    @SuppressWarnings("unchecked")
    private void resize() {
        int oldCapacity = capacity;
        capacity *= 2;
        HashNode<K, V>[] oldBuckets = buckets;
        buckets = new HashNode[capacity];
        size = 0;
        
        for (int i = 0; i < oldCapacity; i++) {
            HashNode<K, V> current = oldBuckets[i];
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }
    
    public void display() {
        System.out.println("Custom HashMap Contents:");
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            HashNode<K, V> current = buckets[i];
            if (current == null) {
                System.out.println("empty");
            } else {
                while (current != null) {
                    System.out.print("[" + current.key + "=" + current.value + "]");
                    if (current.next != null) {
                        System.out.print(" -> ");
                    }
                    current = current.next;
                }
                System.out.println();
            }
        }
        System.out.println("Size: " + size + ", Capacity: " + capacity);
    }
    
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>(8);
        
        System.out.println("=== Custom HashMap Implementation ===");
        
        System.out.println("\n--- Adding key-value pairs ---");
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);
        map.put("date", 4);
        map.put("elderberry", 5);
        map.put("fig", 6);
        map.put("grape", 7);
        map.put("honeydew", 8);
        
        map.display();
        
        System.out.println("\n--- Testing get operations ---");
        System.out.println("Value for 'apple': " + map.get("apple"));
        System.out.println("Value for 'banana': " + map.get("banana"));
        System.out.println("Value for 'mango': " + map.get("mango"));
        
        System.out.println("\n--- Testing containsKey ---");
        System.out.println("Contains 'cherry': " + map.containsKey("cherry"));
        System.out.println("Contains 'orange': " + map.containsKey("orange"));
        
        System.out.println("\n--- Testing containsValue ---");
        System.out.println("Contains value 3: " + map.containsValue(3));
        System.out.println("Contains value 10: " + map.containsValue(10));
        
        System.out.println("\n--- Testing update operation ---");
        map.put("apple", 10);
        System.out.println("Updated value for 'apple': " + map.get("apple"));
        
        System.out.println("\n--- Testing remove operation ---");
        Integer removedValue = map.remove("banana");
        System.out.println("Removed 'banana' with value: " + removedValue);
        System.out.println("Contains 'banana' after removal: " + map.containsKey("banana"));
        
        map.display();
        
        System.out.println("\n--- Testing keySet and values ---");
        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());
        
        System.out.println("\n--- Testing size and isEmpty ---");
        System.out.println("Size: " + map.size());
        System.out.println("Is empty: " + map.isEmpty());
        
        System.out.println("\n--- Testing clear ---");
        map.clear();
        System.out.println("Size after clear: " + map.size());
        System.out.println("Is empty after clear: " + map.isEmpty());
        
        map.display();
    }
} 