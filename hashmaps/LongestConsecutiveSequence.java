package hashmaps;
import java.util.*;

public class LongestConsecutiveSequence {
    public static int findLongestConsecutiveSequence(int[] arr) {
        Set<Integer> numberSet = new HashSet<>();
        for (int num : arr) {
            numberSet.add(num);
        }
        
        int maxLength = 0;
        
        for (int currentNumber : numberSet) {
            if (!numberSet.contains(currentNumber - 1)) {
                int currentLength = 1;
                int nextNumber = currentNumber + 1;
                
                while (numberSet.contains(nextNumber)) {
                    currentLength++;
                    nextNumber++;
                }
                
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        
        return maxLength;
    }
    
    public static List<Integer> findLongestConsecutiveSequenceElements(int[] arr) {
        Set<Integer> numberSet = new HashSet<>();
        for (int num : arr) {
            numberSet.add(num);
        }
        
        int maxLength = 0;
        int startNumber = 0;
        
        for (int currentNumber : numberSet) {
            if (!numberSet.contains(currentNumber - 1)) {
                int currentLength = 1;
                int nextNumber = currentNumber + 1;
                
                while (numberSet.contains(nextNumber)) {
                    currentLength++;
                    nextNumber++;
                }
                
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startNumber = currentNumber;
                }
            }
        }
        
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            sequence.add(startNumber + i);
        }
        
        return sequence;
    }
    
    public static void main(String[] args) {
        int[] testArray1 = {100, 4, 200, 1, 3, 2};
        int[] testArray2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] testArray3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] testArray4 = {5, 2, 8, 1, 9, 3, 7};
        
        System.out.println("Test Array 1: " + Arrays.toString(testArray1));
        int length1 = findLongestConsecutiveSequence(testArray1);
        System.out.println("Longest consecutive sequence length: " + length1);
        List<Integer> sequence1 = findLongestConsecutiveSequenceElements(testArray1);
        System.out.println("Longest consecutive sequence: " + sequence1);
        
        System.out.println("\nTest Array 2: " + Arrays.toString(testArray2));
        int length2 = findLongestConsecutiveSequence(testArray2);
        System.out.println("Longest consecutive sequence length: " + length2);
        List<Integer> sequence2 = findLongestConsecutiveSequenceElements(testArray2);
        System.out.println("Longest consecutive sequence: " + sequence2);
        
        System.out.println("\nTest Array 3: " + Arrays.toString(testArray3));
        int length3 = findLongestConsecutiveSequence(testArray3);
        System.out.println("Longest consecutive sequence length: " + length3);
        List<Integer> sequence3 = findLongestConsecutiveSequenceElements(testArray3);
        System.out.println("Longest consecutive sequence: " + sequence3);
        
        System.out.println("\nTest Array 4: " + Arrays.toString(testArray4));
        int length4 = findLongestConsecutiveSequence(testArray4);
        System.out.println("Longest consecutive sequence length: " + length4);
        List<Integer> sequence4 = findLongestConsecutiveSequenceElements(testArray4);
        System.out.println("Longest consecutive sequence: " + sequence4);
    }
} 