package staticfinalthisinstanceof;

class Patient {
    static String hospitalName = "City Care Hospital";
    static int totalPatients = 0;

    private String name;
    private int age;
    private String ailment;
    private final int patientID;

    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    public void displayDetails() {
        System.out.println("Hospital Name : " + hospitalName);
        System.out.println("Patient Name  : " + name);
        System.out.println("Age           : " + age);
        System.out.println("Ailment       : " + ailment);
        System.out.println("Patient ID    : " + patientID);
    }
}

public class PatientClass {
    public static void main(String[] args) {
        Patient p1 = new Patient("Rahul Mehra", 45, "Diabetes", 201);
        Patient p2 = new Patient("Priya Kapoor", 30, "Asthma", 202);

        if (p1 instanceof Patient) {
            p1.displayDetails();
        }

        if (p2 instanceof Patient) {
            p2.displayDetails();
        }

        Patient.getTotalPatients();
    }
}
