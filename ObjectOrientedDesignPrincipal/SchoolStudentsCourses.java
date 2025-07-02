import java.util.List;
import java.util.ArrayList;
public class SchoolStudentsCourses {
    class Course {
        private String courseName;
        private List<Student> enrolledStudents;

        public Course(String courseName) {
            this.courseName = courseName;
            this.enrolledStudents = new ArrayList<>();
        }

        public void enrollStudent(Student student) {
            enrolledStudents.add(student);
            student.addCourse(this);
        }

        public List<Student> getEnrolledStudents() {
            return enrolledStudents;
        }

        public String getCourseName() {
            return courseName;
        }
    }

    class Student {
        private String studentName;
        private List<Course> courses;

        public Student(String studentName) {
            this.studentName = studentName;
            this.courses = new ArrayList<>();
        }

        public void addCourse(Course course) {
            courses.add(course);
        }

        public List<Course> getCourses() {
            return courses;
        }

        public String getStudentName() {
            return studentName;
        }
    }

    class School {
        private String schoolName;
        private List<Student> students;

        public School(String schoolName) {
            this.schoolName = schoolName;
            this.students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public List<Student> getStudents() {
            return students;
        }

        public String getSchoolName() {
            return schoolName;
        }
    }

    public static void main(String[] args) {
        SchoolStudentsCourses model = new SchoolStudentsCourses();
        School school = model.new School("Greenwood High");
        Student student1 = model.new Student("Alice");
        Student student2 = model.new Student("Bob");
        Course course1 = model.new Course("Mathematics");
        Course course2 = model.new Course("Science");

        school.addStudent(student1);
        school.addStudent(student2);
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course2.enrollStudent(student1);

        System.out.println("Students enrolled in " + course1.getCourseName() + ":");
        for (Student student : course1.getEnrolledStudents()) {
            System.out.println(student.getStudentName());
        }

        System.out.println("Courses for " + student1.getStudentName() + ":");
        for (Course course : student1.getCourses()) {
            System.out.println(course.getCourseName());
        }
    }
}