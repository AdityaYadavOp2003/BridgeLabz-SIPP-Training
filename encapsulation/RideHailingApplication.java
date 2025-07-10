package encapsulation;
abstract class Vehicle {
    private String vehicleIdentifier;
    private String operatorName;
    private double ratePerKilometer;

    public Vehicle(String vehicleIdentifier, String operatorName, double ratePerKilometer) {
        this.vehicleIdentifier = vehicleIdentifier;
        this.operatorName = operatorName;
        this.ratePerKilometer = ratePerKilometer;
    }

    public String getVehicleIdentifier() { return vehicleIdentifier; }
    public String getOperatorName() { return operatorName; }
    public double getRatePerKilometer() { return ratePerKilometer; }

    abstract double calculateFare(double travelDistance);
    
    void getVehicleDetails() {
        System.out.println("Vehicle: " + vehicleIdentifier + ", Driver: " + operatorName + ", Rate: " + ratePerKilometer);
    }
}

interface GPS {
    void getCurrentLocation();
    void updateLocation();
}

class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleIdentifier, String operatorName, double ratePerKilometer, String currentLocation) {
        super(vehicleIdentifier, operatorName, ratePerKilometer);
        this.currentLocation = currentLocation;
    }

    public double calculateFare(double travelDistance) {
        return getRatePerKilometer() * travelDistance;
    }

    public void getCurrentLocation() {
        System.out.println("Car location: " + currentLocation);
    }

    public void updateLocation() {
        System.out.println("Car location updated");
    }
}

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleIdentifier, String operatorName, double ratePerKilometer, String currentLocation) {
        super(vehicleIdentifier, operatorName, ratePerKilometer);
        this.currentLocation = currentLocation;
    }

    public double calculateFare(double travelDistance) {
        return getRatePerKilometer() * travelDistance * 0.6;
    }

    public void getCurrentLocation() {
        System.out.println("Bike location: " + currentLocation);
    }

    public void updateLocation() {
        System.out.println("Bike location updated");
    }
}

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleIdentifier, String operatorName, double ratePerKilometer, String currentLocation) {
        super(vehicleIdentifier, operatorName, ratePerKilometer);
        this.currentLocation = currentLocation;
    }

    public double calculateFare(double travelDistance) {
        return getRatePerKilometer() * travelDistance * 0.8;
    }

    public void getCurrentLocation() {
        System.out.println("Auto location: " + currentLocation);
    }

    public void updateLocation() {
        System.out.println("Auto location updated");
    }
} 