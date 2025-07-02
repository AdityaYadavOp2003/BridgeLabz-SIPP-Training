package JavaClassAndObject.Level1;

class Item {
    String itemCode;
    String itemName;
    double price;

    Item(String code, String name, double price) {
        this.itemCode = code;
        this.itemName = name;
        this.price = price;
    }

    void displayDetails(int quantity) {
        System.out.println("Item: " + itemName + " | Code: " + itemCode + " | Unit Price: ₹" + price);
        System.out.println("Total Cost for " + quantity + " items: ₹" + (price * quantity));
    }

    public static void main(String[] args) {
        Item item = new Item("I101", "USB Drive", 500);
        item.displayDetails(3);
    }
}
