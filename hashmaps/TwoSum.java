package hashmaps;
import java.util.*;

public class TwoSum {
    public static int[] findTwoSum(int[] arr, int targetSum) {
        Map<Integer, Integer> numberIndexMap = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            int complement = targetSum - arr[i];
            
            if (numberIndexMap.containsKey(complement)) {
                return new int[]{numberIndexMap.get(complement), i};
            }
            
            numberIndexMap.put(arr[i], i);
        }
        
        return new int[]{-1, -1};
    }
    
    public static List<int[]> findAllTwoSumPairs(int[] arr, int targetSum) {
        List<int[]> pairs = new ArrayList<>();
        Map<Integer, List<Integer>> numberIndicesMap = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            int complement = targetSum - arr[i];
            
            if (numberIndicesMap.containsKey(complement)) {
                for (int index : numberIndicesMap.get(complement)) {
                    pairs.add(new int[]{index, i});
                }
            }
            
            if (!numberIndicesMap.containsKey(arr[i])) {
                numberIndicesMap.put(arr[i], new ArrayList<>());
            }
            numberIndicesMap.get(arr[i]).add(i);
        }
        
        return pairs;
    }
    
    public static boolean hasTwoSum(int[] arr, int targetSum) {
        Set<Integer> visitedNumbers = new HashSet<>();
        
        for (int currentNumber : arr) {
            int complement = targetSum - currentNumber;
            
            if (visitedNumbers.contains(complement)) {
                return true;
            }
            
            visitedNumbers.add(currentNumber);
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] testArray1 = {2, 7, 11, 15};
        int targetSum1 = 9;
        
        int[] testArray2 = {3, 2, 4};
        int targetSum2 = 6;
        
        int[] testArray3 = {3, 3};
        int targetSum3 = 6;
        
        int[] testArray4 = {1, 5, 8, 3, 2, 9, 7};
        int targetSum4 = 10;
        
        System.out.println("=== Two Sum Problem Solutions ===");
        
        System.out.println("\nTest Array 1: " + Arrays.toString(testArray1));
        System.out.println("Target Sum: " + targetSum1);
        
        boolean hasTwoSum1 = hasTwoSum(testArray1, targetSum1);
        System.out.println("Has two sum: " + hasTwoSum1);
        
        int[] result1 = findTwoSum(testArray1, targetSum1);
        if (result1[0] != -1) {
            System.out.println("Two Sum found at indices: [" + result1[0] + ", " + result1[1] + "]");
            System.out.println("Values: [" + testArray1[result1[0]] + ", " + testArray1[result1[1]] + "]");
        } else {
            System.out.println("No two sum found");
        }
        
        List<int[]> allPairs1 = findAllTwoSumPairs(testArray1, targetSum1);
        System.out.println("All pairs with sum " + targetSum1 + ":");
        for (int[] pair : allPairs1) {
            System.out.println("Indices [" + pair[0] + ", " + pair[1] + "] -> Values [" + 
                             testArray1[pair[0]] + ", " + testArray1[pair[1]] + "]");
        }
        
        System.out.println("\nTest Array 2: " + Arrays.toString(testArray2));
        System.out.println("Target Sum: " + targetSum2);
        
        boolean hasTwoSum2 = hasTwoSum(testArray2, targetSum2);
        System.out.println("Has two sum: " + hasTwoSum2);
        
        int[] result2 = findTwoSum(testArray2, targetSum2);
        if (result2[0] != -1) {
            System.out.println("Two Sum found at indices: [" + result2[0] + ", " + result2[1] + "]");
            System.out.println("Values: [" + testArray2[result2[0]] + ", " + testArray2[result2[1]] + "]");
        } else {
            System.out.println("No two sum found");
        }
        
        System.out.println("\nTest Array 3: " + Arrays.toString(testArray3));
        System.out.println("Target Sum: " + targetSum3);
        
        boolean hasTwoSum3 = hasTwoSum(testArray3, targetSum3);
        System.out.println("Has two sum: " + hasTwoSum3);
        
        int[] result3 = findTwoSum(testArray3, targetSum3);
        if (result3[0] != -1) {
            System.out.println("Two Sum found at indices: [" + result3[0] + ", " + result3[1] + "]");
            System.out.println("Values: [" + testArray3[result3[0]] + ", " + testArray3[result3[1]] + "]");
        } else {
            System.out.println("No two sum found");
        }
        
        System.out.println("\nTest Array 4: " + Arrays.toString(testArray4));
        System.out.println("Target Sum: " + targetSum4);
        
        boolean hasTwoSum4 = hasTwoSum(testArray4, targetSum4);
        System.out.println("Has two sum: " + hasTwoSum4);
        
        int[] result4 = findTwoSum(testArray4, targetSum4);
        if (result4[0] != -1) {
            System.out.println("Two Sum found at indices: [" + result4[0] + ", " + result4[1] + "]");
            System.out.println("Values: [" + testArray4[result4[0]] + ", " + testArray4[result4[1]] + "]");
        } else {
            System.out.println("No two sum found");
        }
        
        List<int[]> allPairs4 = findAllTwoSumPairs(testArray4, targetSum4);
        System.out.println("All pairs with sum " + targetSum4 + ":");
        for (int[] pair : allPairs4) {
            System.out.println("Indices [" + pair[0] + ", " + pair[1] + "] -> Values [" + 
                             testArray4[pair[0]] + ", " + testArray4[pair[1]] + "]");
        }
        
        System.out.println("\n--- Testing edge cases ---");
        int[] emptyArray = {};
        int[] singleElementArray = {5};
        int[] noSolutionArray = {1, 2, 3, 4, 5};
        
        System.out.println("Empty array has two sum for target 5: " + hasTwoSum(emptyArray, 5));
        System.out.println("Single element array has two sum for target 5: " + hasTwoSum(singleElementArray, 5));
        System.out.println("No solution array has two sum for target 20: " + hasTwoSum(noSolutionArray, 20));
    }
} 