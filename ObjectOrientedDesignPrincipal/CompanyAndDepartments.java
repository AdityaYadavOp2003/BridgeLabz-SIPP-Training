import java.util.ArrayList;
import java.util.List;

public class CompanyAndDepartments{
    private String name;
    private List<Department> departments;

    public CompanyAndDepartments(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    public String getName() {
        return name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public static void main(String[] args) {
        CompanyAndDepartments company = new CompanyAndDepartments("Tech Innovations");
        Department devDepartment = new Department("Development");
        Department hrDepartment = new Department("Human Resources");

        Employee emp1 = new Employee("Alice");
        Employee emp2 = new Employee("Bob");

        devDepartment.addEmployee(emp1);
        hrDepartment.addEmployee(emp2);

        company.addDepartment(devDepartment);
        company.addDepartment(hrDepartment);

        System.out.println("Company: " + company.getName());
        for (Department dept : company.getDepartments()) {
            System.out.println("Department: " + dept.getName());
            for (Employee emp : dept.getEmployees()) {
                System.out.println("Employee: " + emp.getName());
            }
        }
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}