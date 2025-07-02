package staticfinalthisinstanceof;

class Vehicle {
    static double registrationFee = 5000.0;

    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayDetails() {
        System.out.println("Owner Name         : " + ownerName);
        System.out.println("Vehicle Type       : " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee   : ₹" + registrationFee);
    }
}

public class VehicleClass {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Amit Sharma", "Car", "DL09AB1234");
        Vehicle v2 = new Vehicle("Sneha Rao", "Bike", "MH12XY5678");

        if (v1 instanceof Vehicle) {
            v1.displayDetails();
        }

        if (v2 instanceof Vehicle) {
            v2.displayDetails();
        }

        Vehicle.updateRegistrationFee(5500.0);

        System.out.println("\nAfter updating registration fee:\n");

        if (v1 instanceof Vehicle) {
            v1.displayDetails();
        }

        if (v2 instanceof Vehicle) {
            v2.displayDetails();
        }
    }
}

