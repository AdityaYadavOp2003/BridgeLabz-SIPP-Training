package JavaConstructor.Level2;

public class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Riya", 8.6);

        pg.showName();
        System.out.println("Roll Number: " + pg.rollNumber);
        System.out.println("CGPA: " + pg.getCGPA());

        pg.setCGPA(9.0);
        System.out.println("Updated CGPA: " + pg.getCGPA());
    }
}

class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void showName() {
        System.out.println("Postgraduate Student Name: " + name); // protected access
    }
}
