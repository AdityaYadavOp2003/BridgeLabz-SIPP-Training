package Level3;

import java.util.Random;

public class FootballTeamHeights {
    public static int sum(int[] arr) {
        int total = 0;
        for (int h : arr) total += h;
        return total;
    }
    public static double mean(int[] arr) {
        return sum(arr) / (double) arr.length;
    }
    public static int min(int[] arr) {
        int min = arr[0];
        for (int h : arr) if (h < min) min = h;
        return min;
    }
    public static int max(int[] arr) {
        int max = arr[0];
        for (int h : arr) if (h > max) max = h;
        return max;
    }
    public static void main(String[] args) {
        Random rand = new Random();
        int[] heights = new int[11];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = rand.nextInt(101) + 150; // 150 to 250
        }
        System.out.print("Heights: ");
        for (int h : heights) System.out.print(h + " ");
        System.out.println();
        System.out.println("Shortest: " + min(heights));
        System.out.println("Tallest: " + max(heights));
        System.out.printf("Mean height: %.2f\n", mean(heights));
    }
}
