package staticfinalthisinstanceof;

class Employee {
    static String companyName = "Tech Innovators Pvt Ltd";
    static int totalEmployees = 0;

    private String name;
    private final int id;
    private String designation;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        System.out.println("Company Name : " + companyName);
        System.out.println("Name         : " + name);
        System.out.println("Employee ID  : " + id);
        System.out.println("Designation  : " + designation);
    }
}

public class EmployeeClass {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", 101, "Software Engineer");
        Employee emp2 = new Employee("Bob", 102, "HR Manager");

        if (emp1 instanceof Employee) {
            emp1.displayDetails();
        }

        if (emp2 instanceof Employee) {
            emp2.displayDetails();
        }

        Employee.displayTotalEmployees();
    }
}
