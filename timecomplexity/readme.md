1. Problem Statement: Search a Target in a Large Dataset
Objective:
Compare the performance of Linear Search (O(N)) and Binary Search (O(log N)) on different dataset sizes.
Approach:
Linear Search: Scan each element until the target is found.
Binary Search: Sort the data first (O(N log N)), then perform O(log N) search.
Comparative Analysis:
Dataset Size (N)
Linear Search (O(N))
Binary Search (O(log N))
1,000
1ms
0.01ms
10,000
10ms
0.02ms
1,000,000
1s
0.1ms

Expected Result:
Binary Search performs much better for large datasets, provided data is sorted.

2. Problem Statement: Sorting Large Data Efficiently
Objective:
Compare sorting algorithms Bubble Sort (O(N²)), Merge Sort (O(N log N)), and Quick Sort (O(N log N)).
Approach:
Bubble Sort: Repeated swapping (inefficient for large data).
Merge Sort: Divide & Conquer approach (stable).
Quick Sort: Partition-based approach (fast but unstable).



Comparative Analysis:
Dataset Size (N)
Bubble Sort (O(N²))
Merge Sort (O(N log N))
Quick Sort (O(N log N))
1,000
50ms
5ms
3ms
10,000
5s
50ms
30ms
1,000,000
Unfeasible (>1hr)
3s
2s

Expected Result:
Bubble Sort is impractical for large datasets.
Merge Sort & Quick Sort perform well.

3. Problem Statement: String Concatenation Performance
Objective:
Compare the performance of String (O(N²)), StringBuilder (O(N)), and StringBuffer (O(N)) when concatenating a million strings.
Approach:
Using String (Immutable, creates new object each time)
Using StringBuilder (Fast, mutable, thread-unsafe)
Using StringBuffer (Thread-safe, slightly slower than StringBuilder)
Comparative Analysis:
Operations Count (N)
String (O(N²))
StringBuilder (O(N))
StringBuffer (O(N))
1,000
10ms
1ms
2ms
10,000
1s
10ms
12ms
1,000,000
30m (Unusable)
50ms
60ms

Expected Result:
StringBuilder & StringBuffer are much more efficient than String.
Use StringBuilder for single-threaded operations and StringBuffer for multi-threaded.

4. Problem Statement: Large File Reading Efficiency
Objective:
Compare FileReader (Character Stream) and InputStreamReader (Byte Stream) when reading a large file (500MB).
Approach:
FileReader: Reads character by character (slower for binary files).
InputStreamReader: Reads bytes and converts to characters (more efficient).
Comparative Analysis:
File Size
FileReader Time
InputStreamReader Time
1MB
50ms
30ms
100MB
3s
1.5s
500MB
10s
5s

Expected Result:
InputStreamReader is more efficient for large files.
FileReader is preferable for text-based data.

5. Problem Statement: Recursive vs Iterative Fibonacci Computation
Objective:
Compare Recursive (O(2ⁿ)) vs Iterative (O(N)) Fibonacci solutions.
Approach:
Recursive:
public static int fibonacciRecursive(int n) {
    if (n <= 1) return n;
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

Iterative:
public static int fibonacciIterative(int n) {
    int a = 0, b = 1, sum;
    for (int i = 2; i <= n; i++) {
        sum = a + b;
        a = b;
        b = sum;
    }
    return b;
}
Comparative Analysis:
Fibonacci (N)
Recursive (O(2ⁿ))
Iterative (O(N))
10
1ms
0.01ms
30
5s
0.05ms
50
Unfeasible (>1hr)
0.1ms

Expected Result:
Recursive approach is infeasible for large values of N due to exponential growth.
The iterative approach is significantly faster and memory-efficient.

6. Problem Statement: Comparing Different Data Structures for Searching
Objective:
Compare Array (O(N)), HashSet (O(1)), and TreeSet (O(log N)) for searching elements.
Approach:
Array: Linear search (O(N)).
HashSet: Uses hashing (O(1) on average).
TreeSet: Balanced BST (O(log N)).
Comparative Analysis:
Dataset Size (N)
Array Search (O(N))
HashSet Search (O(1))
TreeSet Search (O(log N))
1,000
1ms
0.01ms
0.1ms
100,000
100ms
0.01ms
10ms
1,000,000
1s
0.01ms
20ms

Expected Result:
HashSet is fastest for lookups but requires extra memory.
TreeSet maintains order but is slightly slower than HashSet.
