package JavaClassAndObject.Level1;

class MobilePhone {
    String brand;
    String model;
    double price;

    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Price: ₹" + price);
    }

    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone("Samsung", "Galaxy S24", 79999);
        phone.displayDetails();
    }
}
