package encapsulation;
abstract class Vehicle {
    private String registrationPlate;
    private String vehicleCategory;
    private double dailyRate;

    public Vehicle(String registrationPlate, String vehicleCategory, double dailyRate) {
        this.registrationPlate = registrationPlate;
        this.vehicleCategory = vehicleCategory;
        this.dailyRate = dailyRate;
    }

    public String getRegistrationPlate() { return registrationPlate; }
    public String getVehicleCategory() { return vehicleCategory; }
    public double getDailyRate() { return dailyRate; }

    abstract double calculateRentalCost(int rentalDays);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String policyNumber;

    public Car(String registrationPlate, String vehicleCategory, double dailyRate, String policyNumber) {
        super(registrationPlate, vehicleCategory, dailyRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int rentalDays) {
        return getDailyRate() * rentalDays;
    }

    public double calculateInsurance() {
        return getDailyRate() * 0.1;
    }

    public String getInsuranceDetails() {
        return "Policy: " + policyNumber + ", Insurance: " + calculateInsurance();
    }
}

class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    public Bike(String registrationPlate, String vehicleCategory, double dailyRate, String policyNumber) {
        super(registrationPlate, vehicleCategory, dailyRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int rentalDays) {
        return getDailyRate() * rentalDays * 0.7;
    }

    public double calculateInsurance() {
        return getDailyRate() * 0.05;
    }

    public String getInsuranceDetails() {
        return "Policy: " + policyNumber + ", Insurance: " + calculateInsurance();
    }
}

class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    public Truck(String registrationPlate, String vehicleCategory, double dailyRate, String policyNumber) {
        super(registrationPlate, vehicleCategory, dailyRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int rentalDays) {
        return getDailyRate() * rentalDays * 1.5;
    }

    public double calculateInsurance() {
        return getDailyRate() * 0.2;
    }

    public String getInsuranceDetails() {
        return "Policy: " + policyNumber + ", Insurance: " + calculateInsurance();
    }
} 