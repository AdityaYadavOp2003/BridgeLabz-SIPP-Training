import java.util.List;
import java.util.ArrayList;
public class UniversityManagementSystem {
    class Student {
        private String name;
        private List<Course> courses;

        public Student(String name) {
            this.name = name;
            this.courses = new ArrayList<>();
        }

        public void enrollCourse(Course course) {
            courses.add(course);
            course.addStudent(this);
        }

        public List<Course> getCourses() {
            return courses;
        }

        public String getName() {
            return name;
        }
    }

    class Professor {
        private String name;
        private List<Course> courses;

        public Professor(String name) {
            this.name = name;
            this.courses = new ArrayList<>();
        }

        public void assignProfessor(Course course) {
            course.setProfessor(this);
            courses.add(course);
        }

        public String getName() {
            return name;
        }
    }

    class Course {
        private String title;
        private List<Student> students;
        private Professor professor;

        public Course(String title) {
            this.title = title;
            this.students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public void setProfessor(Professor professor) {
            this.professor = professor;
        }

        public List<Student> getStudents() {
            return students;
        }

        public String getTitle() {
            return title;
        }

        public Professor getProfessor() {
            return professor;
        }
    }

    public static void main(String[] args) {
        UniversityManagementSystem system = new UniversityManagementSystem();
        Student student1 = system.new Student("Alice");
        Student student2 = system.new Student("Bob");
        Professor professor = system.new Professor("Dr. Smith");
        Course course = system.new Course("Mathematics");

        student1.enrollCourse(course);
        student2.enrollCourse(course);
        professor.assignProfessor(course);

        System.out.println("Course: " + course.getTitle());
        System.out.println("Professor: " + professor.getName());
        System.out.println("Enrolled Students:");
        for (Student student : course.getStudents()) {
            System.out.println(student.getName());
        }
    }
}