package linkedlist;
class StudentNode {
    int rollNum;
    String name;
    int age;
    String grade;
    StudentNode next;
    
    StudentNode(int rollNum, String name, int age, String grade) {
        this.rollNum = rollNum;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private StudentNode head;
    private int size;
    
    StudentLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    void addAtBeginning(int rollNum, String name, int age, String grade) {
        StudentNode newStudent = new StudentNode(rollNum, name, age, grade);
        newStudent.next = this.head;
        this.head = newStudent;
        this.size++;
    }
    
    void addAtEnd(int rollNum, String name, int age, String grade) {
        StudentNode newStudent = new StudentNode(rollNum, name, age, grade);
        if (this.head == null) {
            this.head = newStudent;
        } else {
            StudentNode current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newStudent;
        }
        this.size++;
    }
    
    void addAtPosition(int position, int rollNum, String name, int age, String grade) {
        if (position <= 0) {
            addAtBeginning(rollNum, name, age, grade);
            return;
        }
        
        if (position >= this.size) {
            addAtEnd(rollNum, name, age, grade);
            return;
        }
        
        StudentNode newStudent = new StudentNode(rollNum, name, age, grade);
        StudentNode current = this.head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        newStudent.next = current.next;
        current.next = newStudent;
        this.size++;
    }
    
    boolean deleteByRoll(int rollNum) {
        if (this.head == null) {
            return false;
        }
        
        if (this.head.rollNum == rollNum) {
            this.head = this.head.next;
            this.size--;
            return true;
        }
        
        StudentNode current = this.head;
        while (current.next != null) {
            if (current.next.rollNum == rollNum) {
                current.next = current.next.next;
                this.size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    StudentNode searchByRoll(int rollNum) {
        StudentNode current = this.head;
        while (current != null) {
            if (current.rollNum == rollNum) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    void displayAll() {
        if (this.head == null) {
            System.out.println("No students in the list");
            return;
        }
        
        StudentNode current = this.head;
        while (current != null) {
            System.out.println("Roll: " + current.rollNum + ", Name: " + current.name + 
                             ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
    
    boolean updateGrade(int rollNum, String newGrade) {
        StudentNode student = searchByRoll(rollNum);
        if (student != null) {
            student.grade = newGrade;
            return true;
        }
        return false;
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();
        
        studentList.addAtBeginning(101, "Alice", 20, "A");
        studentList.addAtEnd(102, "Bob", 21, "B");
        studentList.addAtPosition(1, 103, "Charlie", 19, "A-");
        studentList.addAtEnd(104, "Diana", 22, "B+");
        
        System.out.println("All students:");
        studentList.displayAll();
        
        System.out.println("\nSearching for student with roll 102:");
        StudentNode foundStudent = studentList.searchByRoll(102);
        if (foundStudent != null) {
            System.out.println("Found: " + foundStudent.name);
        }
        
        System.out.println("\nUpdating grade for roll 101:");
        studentList.updateGrade(101, "A+");
        studentList.displayAll();
        
        System.out.println("\nDeleting student with roll 103:");
        studentList.deleteByRoll(103);
        studentList.displayAll();
    }
} 