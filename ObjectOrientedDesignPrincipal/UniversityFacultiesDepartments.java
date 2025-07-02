import java.util.List;
import java.util.ArrayList;
class University {
    private String name;
    private List<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    public void deleteUniversity() {
        departments.clear();
    }

    public String getName() {
        return name;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}

class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class UniversityFacultiesDepartments {
    public static void main(String[] args) {
        University university = new University("Tech University");
        Department csDepartment = new Department("Computer Science");
        Department eeDepartment = new Department("Electrical Engineering");
        
        university.addDepartment(csDepartment);
        university.addDepartment(eeDepartment);
        
        System.out.println("University: " + university.getName());
        System.out.println("Departments:");
        for (Department dept : university.getDepartments()) {
            System.out.println("- " + dept.getName());
        }
        
        university.deleteUniversity();
        System.out.println("Departments after deletion: " + university.getDepartments().size());
        
        Faculty facultyMember = new Faculty("Dr. Smith");
        System.out.println("Faculty Member: " + facultyMember.getName());
    }
}