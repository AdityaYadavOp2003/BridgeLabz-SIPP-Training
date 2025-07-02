package Level3;

import java.util.*;

public class StudentScorecard {
    public static int[][] generateScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                scores[i][j] = 40 + rand.nextInt(61); // 40-100
        return scores;
    }
    public static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double perc = (total / 300.0) * 100;
            stats[i][0] = total;
            stats[i][1] = Math.round(avg * 100.0) / 100.0;
            stats[i][2] = Math.round(perc * 100.0) / 100.0;
        }
        return stats;
    }
    public static void displayScorecard(int[][] scores, double[][] stats) {
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t% ");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f\n", i+1, scores[i][0], scores[i][1], scores[i][2], stats[i][0], stats[i][1], stats[i][2]);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scn.nextInt();
        int[][] scores = generateScores(n);
        double[][] stats = calculateStats(scores);
        displayScorecard(scores, stats);
    }
}
