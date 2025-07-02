package Level2;

import java.util.*;

public class StudentVoteChecker {
    public static boolean canStudentVote(int age) {
        if (age < 0) return false;
        return age >= 18;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] ages = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age for student " + (i+1) + ": ");
            ages[i] = scn.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            boolean canVote = canStudentVote(ages[i]);
            System.out.println("Student " + (i+1) + " (age " + ages[i] + ") can vote: " + canVote);
        }
    }
}
