package encapsulation;
abstract class FoodItem {
    private String dishName;
    private double dishPrice;
    private int dishQuantity;

    public FoodItem(String dishName, double dishPrice, int dishQuantity) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishQuantity = dishQuantity;
    }

    public String getDishName() { return dishName; }
    public double getDishPrice() { return dishPrice; }
    public int getDishQuantity() { return dishQuantity; }

    abstract double calculateTotalPrice();
    
    void getItemDetails() {
        System.out.println("Dish: " + dishName + ", Price: " + dishPrice + ", Quantity: " + dishQuantity);
    }
}

interface Discountable {
    void applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    private double vegSurcharge;

    public VegItem(String dishName, double dishPrice, int dishQuantity, double vegSurcharge) {
        super(dishName, dishPrice, dishQuantity);
        this.vegSurcharge = vegSurcharge;
    }

    public double calculateTotalPrice() {
        return getDishPrice() * getDishQuantity() + vegSurcharge;
    }

    public void applyDiscount() {
        System.out.println("Veg discount applied");
    }

    public String getDiscountDetails() {
        return "Veg discount: 10%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double nonVegSurcharge;

    public NonVegItem(String dishName, double dishPrice, int dishQuantity, double nonVegSurcharge) {
        super(dishName, dishPrice, dishQuantity);
        this.nonVegSurcharge = nonVegSurcharge;
    }

    public double calculateTotalPrice() {
        return getDishPrice() * getDishQuantity() + nonVegSurcharge;
    }

    public void applyDiscount() {
        System.out.println("Non-veg discount applied");
    }

    public String getDiscountDetails() {
        return "Non-veg discount: 5%";
    }
} 