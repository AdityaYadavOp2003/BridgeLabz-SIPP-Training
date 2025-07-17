package stackques;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] inputArray) {
        HashMap<Integer, List<Integer>> sumIndicesMap = new HashMap<>();
        List<int[]> zeroSumRanges = new ArrayList<>();
        int cumulativeSum = 0;
        sumIndicesMap.put(0, new ArrayList<>());
        sumIndicesMap.get(0).add(-1);
        for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++) {
            cumulativeSum += inputArray[currentIndex];
            if (sumIndicesMap.containsKey(cumulativeSum)) {
                for (int startIndex : sumIndicesMap.get(cumulativeSum)) {
                    zeroSumRanges.add(new int[]{startIndex + 1, currentIndex});
                }
            }
            sumIndicesMap.computeIfAbsent(cumulativeSum, k -> new ArrayList<>()).add(currentIndex);
        }
        return zeroSumRanges;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 4, -7, 1, 3, 3, 1, -4};
        List<int[]> result = findZeroSumSubarrays(numbers);
        for (int[] range : result) {
            System.out.println(range[0] + " to " + range[1]);
        }
    }
} 