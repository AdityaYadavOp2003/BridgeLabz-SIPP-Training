package encapsulation;
abstract class Employee {
    private String staffIdentifier;
    private String fullName;
    private double baseCompensation;

    public Employee(String staffIdentifier, String fullName, double baseCompensation) {
        this.staffIdentifier = staffIdentifier;
        this.fullName = fullName;
        this.baseCompensation = baseCompensation;
    }

    public String getStaffIdentifier() { return staffIdentifier; }
    public String getFullName() { return fullName; }
    public double getBaseCompensation() { return baseCompensation; }

    abstract double calculateSalary();
    
    void displayDetails() {
        System.out.println("ID: " + staffIdentifier + ", Name: " + fullName + ", Salary: " + calculateSalary());
    }
}

interface Department {
    void assignDepartment(String deptCode);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private String assignedDept;
    private int weeklyHours;

    public FullTimeEmployee(String staffIdentifier, String fullName, double baseCompensation, int weeklyHours) {
        super(staffIdentifier, fullName, baseCompensation);
        this.weeklyHours = weeklyHours;
    }

    public double calculateSalary() {
        return getBaseCompensation() * (weeklyHours / 40.0);
    }

    public void assignDepartment(String deptCode) {
        this.assignedDept = deptCode;
    }

    public String getDepartmentDetails() {
        return assignedDept;
    }
}

class PartTimeEmployee extends Employee implements Department {
    private String assignedDept;
    private int hourlyRate;

    public PartTimeEmployee(String staffIdentifier, String fullName, double baseCompensation, int hourlyRate) {
        super(staffIdentifier, fullName, baseCompensation);
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalary() {
        return hourlyRate * 20;
    }

    public void assignDepartment(String deptCode) {
        this.assignedDept = deptCode;
    }

    public String getDepartmentDetails() {
        return assignedDept;
    }
} 