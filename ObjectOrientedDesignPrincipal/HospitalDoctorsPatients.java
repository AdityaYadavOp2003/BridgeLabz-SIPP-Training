public class HospitalDoctorsPatients {
    class Hospital {
        private String name;

        public Hospital(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    class Doctor {
        private String name;

        public Doctor(String name) {
            this.name = name;
        }

        public void consult(Patient patient) {
            System.out.println(name + " is consulting with " + patient.getName());
        }

        public String getName() {
            return name;
        }
    }

    class Patient {
        private String name;

        public Patient(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        HospitalDoctorsPatients hospitalSystem = new HospitalDoctorsPatients();
        Hospital hospital = hospitalSystem.new Hospital("City Hospital");
        Doctor doctor = hospitalSystem.new Doctor("Dr. Smith");
        Patient patient = hospitalSystem.new Patient("John Doe");

        System.out.println("Welcome to " + hospital.getName());
        doctor.consult(patient);
    }
}