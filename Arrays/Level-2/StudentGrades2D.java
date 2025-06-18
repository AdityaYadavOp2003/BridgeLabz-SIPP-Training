import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        double[][] marks = new double[n][3];
        double[] percentage = new double[n];
        String[] grade = new String[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter physics marks for student " + (i+1) + ": ");
            marks[i][0] = sc.nextDouble();
            System.out.print("Enter chemistry marks for student " + (i+1) + ": ");
            marks[i][1] = sc.nextDouble();
            System.out.print("Enter maths marks for student " + (i+1) + ": ");
            marks[i][2] = sc.nextDouble();
            
            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.out.println("Please enter positive values.");
                i--;
                continue;
            }
            
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3;
            
            if (percentage[i] >= 90) grade[i] = "A+";
            else if (percentage[i] >= 80) grade[i] = "A";
            else if (percentage[i] >= 70) grade[i] = "B";
            else if (percentage[i] >= 60) grade[i] = "C";
            else if (percentage[i] >= 50) grade[i] = "D";
            else grade[i] = "F";
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i+1) + ": Physics=" + marks[i][0] + ", Chemistry=" + marks[i][1] + ", Maths=" + marks[i][2] + ", Percentage=" + String.format("%.2f", percentage[i]) + "%, Grade=" + grade[i]);
        }
    }
} 