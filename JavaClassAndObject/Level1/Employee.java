package JavaClassAndObject.Level1;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: ₹" + salary);
    }

    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 101, 55000);
        emp.displayDetails();
    }
}
