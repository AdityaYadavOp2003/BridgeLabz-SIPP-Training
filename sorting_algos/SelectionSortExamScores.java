package sorting_algos;

public class SelectionSortExamScores {
    public static void sortExamScores(int[] examScores) {
        int numberOfScores = examScores.length;
        for (int i = 0; i < numberOfScores - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < numberOfScores; j++) {
                if (examScores[j] < examScores[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            int scoreToSwap = examScores[minimumIndex];
            examScores[minimumIndex] = examScores[i];
            examScores[i] = scoreToSwap;
        }
    }
    public static void main(String[] args) {
        int[] scores = {88, 75, 92, 60, 85};
        sortExamScores(scores);
        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
} 