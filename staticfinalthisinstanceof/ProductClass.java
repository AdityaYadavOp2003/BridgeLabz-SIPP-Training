package staticfinalthisinstanceof;

class Product {
    static double discount = 10.0;

    private String productName;
    private double price;
    private int quantity;
    private final int productID;

    public Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayDetails() {
        double discountedPrice = price - (price * discount / 100);
        System.out.println("Product ID      : " + productID);
        System.out.println("Product Name    : " + productName);
        System.out.println("Original Price  : ₹" + price);
        System.out.println("Discounted Price: ₹" + discountedPrice);
        System.out.println("Quantity        : " + quantity);
    }
}

public class ProductClass {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 50000, 1, 101);
        Product p2 = new Product("Headphones", 2000, 2, 102);

        if (p1 instanceof Product) {
            p1.displayDetails();
        }

        if (p2 instanceof Product) {
            p2.displayDetails();
        }

        Product.updateDiscount(15.0);
        System.out.println("\nAfter updating discount:\n");

        if (p1 instanceof Product) {
            p1.displayDetails();
        }

        if (p2 instanceof Product) {
            p2.displayDetails();
        }
    }
}

