package hashmaps;
import java.util.*;

public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int targetSum) {
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
    
    public static List<int[]> findAllPairsWithSum(int[] arr, int targetSum) {
        List<int[]> pairs = new ArrayList<>();
        Map<Integer, List<Integer>> numberIndices = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            int complement = targetSum - arr[i];
            
            if (numberIndices.containsKey(complement)) {
                for (int index : numberIndices.get(complement)) {
                    pairs.add(new int[]{index, i});
                }
            }
            
            if (!numberIndices.containsKey(arr[i])) {
                numberIndices.put(arr[i], new ArrayList<>());
            }
            numberIndices.get(arr[i]).add(i);
        }
        
        return pairs;
    }
    
    public static void main(String[] args) {
        int[] testArray1 = {8, 7, 2, 5, 3, 1};
        int targetSum1 = 10;
        
        int[] testArray2 = {5, 2, 6, 8, 1, 9};
        int targetSum2 = 12;
        
        int[] testArray3 = {1, 2, 3, 4, 5};
        int targetSum3 = 9;
        
        System.out.println("Test Array 1: " + Arrays.toString(testArray1));
        System.out.println("Target Sum: " + targetSum1);
        boolean hasPair1 = hasPairWithSum(testArray1, targetSum1);
        System.out.println("Has pair with sum " + targetSum1 + ": " + hasPair1);
        
        List<int[]> pairs1 = findAllPairsWithSum(testArray1, targetSum1);
        System.out.println("All pairs with sum " + targetSum1 + ":");
        for (int[] pair : pairs1) {
            System.out.println("Indices [" + pair[0] + ", " + pair[1] + "] -> Values [" + 
                             testArray1[pair[0]] + ", " + testArray1[pair[1]] + "]");
        }
        
        System.out.println("\nTest Array 2: " + Arrays.toString(testArray2));
        System.out.println("Target Sum: " + targetSum2);
        boolean hasPair2 = hasPairWithSum(testArray2, targetSum2);
        System.out.println("Has pair with sum " + targetSum2 + ": " + hasPair2);
        
        List<int[]> pairs2 = findAllPairsWithSum(testArray2, targetSum2);
        System.out.println("All pairs with sum " + targetSum2 + ":");
        for (int[] pair : pairs2) {
            System.out.println("Indices [" + pair[0] + ", " + pair[1] + "] -> Values [" + 
                             testArray2[pair[0]] + ", " + testArray2[pair[1]] + "]");
        }
        
        System.out.println("\nTest Array 3: " + Arrays.toString(testArray3));
        System.out.println("Target Sum: " + targetSum3);
        boolean hasPair3 = hasPairWithSum(testArray3, targetSum3);
        System.out.println("Has pair with sum " + targetSum3 + ": " + hasPair3);
        
        List<int[]> pairs3 = findAllPairsWithSum(testArray3, targetSum3);
        System.out.println("All pairs with sum " + targetSum3 + ":");
        for (int[] pair : pairs3) {
            System.out.println("Indices [" + pair[0] + ", " + pair[1] + "] -> Values [" + 
                             testArray3[pair[0]] + ", " + testArray3[pair[1]] + "]");
        }
    }
} 