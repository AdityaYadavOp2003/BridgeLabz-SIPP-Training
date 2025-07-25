import java.util.*;

class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}

class ShoppingCartCore<T extends Item> {
    private final List<T> itemList = new ArrayList<>();

    public void addItem(T item) {
        itemList.add(item);
    }

    public void removeItem(T item) {
        itemList.remove(item);
    }

    public List<T> getItems() {
        return Collections.unmodifiableList(itemList);
    }

    public double getTotalPrice() {
        double total = 0;
        for (T item : itemList) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        ShoppingCartCore<Item> cart = new ShoppingCartCore<>();
        Item apple = new Item("Apple", 2, 1.5);
        Item banana = new Item("Banana", 3, 0.8);
        cart.addItem(apple);
        cart.addItem(banana);
        cart.addItem(apple);
        System.out.println(cart.getTotalPrice());
        cart.removeItem(apple);
        System.out.println(cart.getTotalPrice());
    }
} 