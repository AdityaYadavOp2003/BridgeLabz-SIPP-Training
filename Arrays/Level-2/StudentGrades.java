import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        double[] physics = new double[n];
        double[] chemistry = new double[n];
        double[] maths = new double[n];
        double[] percentage = new double[n];
        String[] grade = new String[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter physics marks for student " + (i+1) + ": ");
            physics[i] = sc.nextDouble();
            System.out.print("Enter chemistry marks for student " + (i+1) + ": ");
            chemistry[i] = sc.nextDouble();
            System.out.print("Enter maths marks for student " + (i+1) + ": ");
            maths[i] = sc.nextDouble();
            
            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
                System.out.println("Please enter positive values.");
                i--;
                continue;
            }
            
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3;
            
            if (percentage[i] >= 90) grade[i] = "A+";
            else if (percentage[i] >= 80) grade[i] = "A";
            else if (percentage[i] >= 70) grade[i] = "B";
            else if (percentage[i] >= 60) grade[i] = "C";
            else if (percentage[i] >= 50) grade[i] = "D";
            else grade[i] = "F";
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i+1) + ": Physics=" + physics[i] + ", Chemistry=" + chemistry[i] + ", Maths=" + maths[i] + ", Percentage=" + String.format("%.2f", percentage[i]) + "%, Grade=" + grade[i]);
        }
    }
} 