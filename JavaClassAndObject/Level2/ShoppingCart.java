package JavaClassAndObject.Level2;

import java.util.*;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String name, double price, int quantity) {
        this.itemName = name;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotal() {
        return price * quantity;
    }
}

class ShoppingCart {
    List<CartItem> cart = new ArrayList<>();

    void addItem(CartItem item) {
        cart.add(item);
        System.out.println(item.itemName + " added to cart.");
    }

    void removeItem(String itemName) {
        cart.removeIf(item -> item.itemName.equalsIgnoreCase(itemName));
        System.out.println(itemName + " removed from cart.");
    }

    void displayTotalCost() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getTotal();
        }
        System.out.println("Total Cost: ₹" + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new CartItem("Book", 250, 2));
        cart.addItem(new CartItem("Pen", 20, 5));
        cart.displayTotalCost();
        cart.removeItem("Pen");
        cart.displayTotalCost();
    }
}
