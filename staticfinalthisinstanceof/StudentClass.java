package staticfinalthisinstanceof;

class Student {
    static String universityName = "Global Tech University";
    static int totalStudents = 0;

    private String name;
    private final int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public void displayDetails() {
        System.out.println("University Name : " + universityName);
        System.out.println("Name            : " + name);
        System.out.println("Roll Number     : " + rollNumber);
        System.out.println("Grade           : " + grade);
    }

    public void updateGrade(String newGrade) {
        this.grade = newGrade;
    }
}

public class StudentClass {
    public static void main(String[] args) {
        Student s1 = new Student("Ananya", 1001, "A");
        Student s2 = new Student("Rohan", 1002, "B");

        if (s1 instanceof Student) {
            s1.displayDetails();
        }

        if (s2 instanceof Student) {
            s2.displayDetails();
        }

        s2.updateGrade("A");

        System.out.println("\nAfter Grade Update:");
        if (s2 instanceof Student) {
            s2.displayDetails();
        }

        Student.displayTotalStudents();
    }
}
