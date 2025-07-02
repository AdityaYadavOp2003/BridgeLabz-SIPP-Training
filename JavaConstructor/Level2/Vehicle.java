package JavaConstructor.Level2;

public class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 2000;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName + ", Vehicle: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle.updateRegistrationFee(2500);
        Vehicle v1 = new Vehicle("Amit", "Car");
        v1.displayVehicleDetails();
    }
}

