package JavaClassAndObject.Level2;

class Student {
    String name;
    int rollNumber;
    int marks;

    Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else return "D";
    }

    void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollNumber + ", Marks: " + marks + ", Grade: " + calculateGrade());
    }

    public static void main(String[] args) {
        Student stu = new Student("Raj", 12, 88);
        stu.display();
    }
}
