import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double physics = sc.nextDouble();
        double chemistry = sc.nextDouble();
        double maths = sc.nextDouble();
        
        double average = (physics + chemistry + maths) / 3;
        String grade;
        String remarks;
        
        if (average >= 90) {
            grade = "A+";
            remarks = "Excellent";
        } else if (average >= 80) {
            grade = "A";
            remarks = "Very Good";
        } else if (average >= 70) {
            grade = "B";
            remarks = "Good";
        } else if (average >= 60) {
            grade = "C";
            remarks = "Average";
        } else if (average >= 50) {
            grade = "D";
            remarks = "Below Average";
        } else {
            grade = "F";
            remarks = "Fail";
        }
        
        System.out.println("Average Mark: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
    }
} 