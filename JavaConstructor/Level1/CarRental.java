package JavaConstructor.Level1;

public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double ratePerDay = 1000.0;

    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Standard";
        this.rentalDays = 1;
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * ratePerDay;
    }

    public void displayRentalDetails() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Days: " + rentalDays);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental rental = new CarRental("Ravi", "Hyundai i20", 5);
        rental.displayRentalDetails();
    }
}


