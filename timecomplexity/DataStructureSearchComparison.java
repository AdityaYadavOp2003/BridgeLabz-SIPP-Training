package timecomplexity;

import java.util.HashSet;
import java.util.TreeSet;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int datasetSize = 1000000;
        int[] integerArray = new int[datasetSize];
        HashSet<Integer> integerHashSet = new HashSet<>();
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        for (int index = 0; index < datasetSize; index++) {
            integerArray[index] = index * 2;
            integerHashSet.add(index * 2);
            integerTreeSet.add(index * 2);
        }
        int searchElement = 123456;
        long arrayStartTime = System.nanoTime();
        boolean arrayFound = false;
        for (int value : integerArray) {
            if (value == searchElement) {
                arrayFound = true;
                break;
            }
        }
        long arrayEndTime = System.nanoTime();
        long arrayDuration = arrayEndTime - arrayStartTime;
        long hashSetStartTime = System.nanoTime();
        boolean hashSetFound = integerHashSet.contains(searchElement);
        long hashSetEndTime = System.nanoTime();
        long hashSetDuration = hashSetEndTime - hashSetStartTime;
        long treeSetStartTime = System.nanoTime();
        boolean treeSetFound = integerTreeSet.contains(searchElement);
        long treeSetEndTime = System.nanoTime();
        long treeSetDuration = treeSetEndTime - treeSetStartTime;
        System.out.println("Array Search: " + arrayFound + ", Time: " + arrayDuration + " ns");
        System.out.println("HashSet Search: " + hashSetFound + ", Time: " + hashSetDuration + " ns");
        System.out.println("TreeSet Search: " + treeSetFound + ", Time: " + treeSetDuration + " ns");
    }
} 