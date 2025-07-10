package hashmaps;
import java.util.*;

public class ZeroSumSubarrays {
    public static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int cumulativeSum = 0;
        
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));
        
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];
            
            if (sumMap.containsKey(cumulativeSum)) {
                List<Integer> indices = sumMap.get(cumulativeSum);
                for (int startIndex : indices) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = startIndex + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray);
                }
                indices.add(i);
            } else {
                List<Integer> newIndices = new ArrayList<>();
                newIndices.add(i);
                sumMap.put(cumulativeSum, newIndices);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] testArray1 = {4, 2, -3, -1, 0, 4};
        int[] testArray2 = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        int[] testArray3 = {0, 0, 0, 0};
        
        System.out.println("Test Array 1: " + Arrays.toString(testArray1));
        List<List<Integer>> result1 = findZeroSumSubarrays(testArray1);
        System.out.println("Zero sum subarrays:");
        for (List<Integer> subarray : result1) {
            System.out.println(subarray + " (sum: " + subarray.stream().mapToInt(Integer::intValue).sum() + ")");
        }
        
        System.out.println("\nTest Array 2: " + Arrays.toString(testArray2));
        List<List<Integer>> result2 = findZeroSumSubarrays(testArray2);
        System.out.println("Zero sum subarrays:");
        for (List<Integer> subarray : result2) {
            System.out.println(subarray + " (sum: " + subarray.stream().mapToInt(Integer::intValue).sum() + ")");
        }
        
        System.out.println("\nTest Array 3: " + Arrays.toString(testArray3));
        List<List<Integer>> result3 = findZeroSumSubarrays(testArray3);
        System.out.println("Zero sum subarrays:");
        for (List<Integer> subarray : result3) {
            System.out.println(subarray + " (sum: " + subarray.stream().mapToInt(Integer::intValue).sum() + ")");
        }
    }
} 