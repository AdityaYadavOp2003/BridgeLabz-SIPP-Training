package JavaConstructor.Level2;

public class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "Default Institute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " months, Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String name) {
        instituteName = name;
    }


    public static void main(String[] args) {
        Course.updateInstituteName("OpenAI Academy");
        Course c1 = new Course("Java", 6, 12000);
        c1.displayCourseDetails();
    }
}

