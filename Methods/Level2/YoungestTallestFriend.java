import java.util.*;

public class YoungestTallestFriend {
    public static int findYoungest(int[] ages) {
        int min = ages[0], idx = 0;
        for (int i = 1; i < ages.length; i++) if (ages[i] < min) { min = ages[i]; idx = i; }
        return idx;
    }
    public static int findTallest(double[] heights) {
        double max = heights[0]; int idx = 0;
        for (int i = 1; i < heights.length; i++) if (heights[i] > max) { max = heights[i]; idx = i; }
        return idx;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            ages[i] = scn.nextInt();
            System.out.print("Enter height (cm) for " + names[i] + ": ");
            heights[i] = scn.nextDouble();
        }
        int yIdx = findYoungest(ages);
        int tIdx = findTallest(heights);
        System.out.println("Youngest: " + names[yIdx] + " (" + ages[yIdx] + ")");
        System.out.println("Tallest: " + names[tIdx] + " (" + heights[tIdx] + " cm)");
    }
}
