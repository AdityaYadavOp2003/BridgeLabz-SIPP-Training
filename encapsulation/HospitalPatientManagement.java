package encapsulation;
abstract class Patient {
    private String patientIdentifier;
    private String patientName;
    private int patientAge;

    public Patient(String patientIdentifier, String patientName, int patientAge) {
        this.patientIdentifier = patientIdentifier;
        this.patientName = patientName;
        this.patientAge = patientAge;
    }

    public String getPatientIdentifier() { return patientIdentifier; }
    public String getPatientName() { return patientName; }
    public int getPatientAge() { return patientAge; }

    abstract double calculateBill();
    
    void getPatientDetails() {
        System.out.println("ID: " + patientIdentifier + ", Name: " + patientName + ", Age: " + patientAge);
    }
}

interface MedicalRecord {
    void addRecord();
    String viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private String diagnosisInfo;
    private int stayDuration;

    public InPatient(String patientIdentifier, String patientName, int patientAge, String diagnosisInfo, int stayDuration) {
        super(patientIdentifier, patientName, patientAge);
        this.diagnosisInfo = diagnosisInfo;
        this.stayDuration = stayDuration;
    }

    public double calculateBill() {
        return stayDuration * 1000;
    }

    public void addRecord() {
        System.out.println("In-patient record added");
    }

    public String viewRecords() {
        return "Diagnosis: " + diagnosisInfo + ", Stay: " + stayDuration + " days";
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private String diagnosisInfo;
    private int visitCount;

    public OutPatient(String patientIdentifier, String patientName, int patientAge, String diagnosisInfo, int visitCount) {
        super(patientIdentifier, patientName, patientAge);
        this.diagnosisInfo = diagnosisInfo;
        this.visitCount = visitCount;
    }

    public double calculateBill() {
        return visitCount * 500;
    }

    public void addRecord() {
        System.out.println("Out-patient record added");
    }

    public String viewRecords() {
        return "Diagnosis: " + diagnosisInfo + ", Visits: " + visitCount;
    }
} 