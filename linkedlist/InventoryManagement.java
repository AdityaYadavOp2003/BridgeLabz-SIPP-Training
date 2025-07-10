package linkedlist;
import java.util.ArrayList;
import java.util.List;

class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;
    
    ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    private ItemNode head;
    private int itemCount;
    
    InventoryLinkedList() {
        this.head = null;
        this.itemCount = 0;
    }
    
    void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        newItem.next = this.head;
        this.head = newItem;
        this.itemCount++;
    }
    
    void addAtEnd(String itemName, int itemId, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        if (this.head == null) {
            this.head = newItem;
        } else {
            ItemNode current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
        this.itemCount++;
    }
    
    void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position <= 0) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        
        if (position >= this.itemCount) {
            addAtEnd(itemName, itemId, quantity, price);
            return;
        }
        
        ItemNode newItem = new ItemNode(itemName, itemId, quantity, price);
        ItemNode current = this.head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        newItem.next = current.next;
        current.next = newItem;
        this.itemCount++;
    }
    
    boolean removeByItemId(int itemId) {
        if (this.head == null) {
            return false;
        }
        
        if (this.head.itemId == itemId) {
            this.head = this.head.next;
            this.itemCount--;
            return true;
        }
        
        ItemNode current = this.head;
        while (current.next != null) {
            if (current.next.itemId == itemId) {
                current.next = current.next.next;
                this.itemCount--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    boolean updateQuantity(int itemId, int newQuantity) {
        ItemNode current = this.head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    ItemNode searchByItemId(int itemId) {
        ItemNode current = this.head;
        while (current != null) {
            if (current.itemId == itemId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    List<ItemNode> searchByItemName(String itemName) {
        List<ItemNode> results = new ArrayList<>();
        ItemNode current = this.head;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(itemName)) {
                results.add(current);
            }
            current = current.next;
        }
        return results;
    }
    
    double calculateTotalValue() {
        double totalValue = 0.0;
        ItemNode current = this.head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        return totalValue;
    }
    
    void sortByName(boolean ascending) {
        if (this.head == null || this.head.next == null) {
            return;
        }
        
        boolean swapped;
        do {
            swapped = false;
            ItemNode current = this.head;
            ItemNode previous = null;
            
            while (current.next != null) {
                int comparison = current.itemName.compareToIgnoreCase(current.next.itemName);
                if ((ascending && comparison > 0) || (!ascending && comparison < 0)) {
                    ItemNode temp = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    
                    if (previous == null) {
                        this.head = temp;
                    } else {
                        previous.next = temp;
                    }
                    
                    previous = temp;
                    swapped = true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
    }
    
    void sortByPrice(boolean ascending) {
        if (this.head == null || this.head.next == null) {
            return;
        }
        
        boolean swapped;
        do {
            swapped = false;
            ItemNode current = this.head;
            ItemNode previous = null;
            
            while (current.next != null) {
                if ((ascending && current.price > current.next.price) || 
                    (!ascending && current.price < current.next.price)) {
                    ItemNode temp = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    
                    if (previous == null) {
                        this.head = temp;
                    } else {
                        previous.next = temp;
                    }
                    
                    previous = temp;
                    swapped = true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
    }
    
    void displayAllItems() {
        if (this.head == null) {
            System.out.println("No items in inventory");
            return;
        }
        
        ItemNode current = this.head;
        while (current != null) {
            System.out.println("ID: " + current.itemId + ", Name: " + current.itemName + 
                             ", Quantity: " + current.quantity + ", Price: $" + current.price);
            current = current.next;
        }
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();
        
        inventory.addAtBeginning("Laptop", 1001, 5, 999.99);
        inventory.addAtEnd("Mouse", 1002, 20, 25.50);
        inventory.addAtPosition(1, "Keyboard", 1003, 15, 75.00);
        inventory.addAtEnd("Monitor", 1004, 8, 299.99);
        inventory.addAtEnd("Headphones", 1005, 12, 89.99);
        
        System.out.println("All inventory items:");
        inventory.displayAllItems();
        
        System.out.println("\nTotal inventory value: $" + inventory.calculateTotalValue());
        
        System.out.println("\nSearching for item with ID 1002:");
        ItemNode foundItem = inventory.searchByItemId(1002);
        if (foundItem != null) {
            System.out.println("Found: " + foundItem.itemName);
        }
        
        System.out.println("\nSearching for items with name containing 'Laptop':");
        List<ItemNode> laptopItems = inventory.searchByItemName("Laptop");
        for (ItemNode item : laptopItems) {
            System.out.println("Found: " + item.itemName + " (ID: " + item.itemId + ")");
        }
        
        System.out.println("\nUpdating quantity for item 1001:");
        inventory.updateQuantity(1001, 8);
        inventory.displayAllItems();
        
        System.out.println("\nSorting by name (ascending):");
        inventory.sortByName(true);
        inventory.displayAllItems();
        
        System.out.println("\nSorting by price (descending):");
        inventory.sortByPrice(false);
        inventory.displayAllItems();
        
        System.out.println("\nRemoving item with ID 1003:");
        inventory.removeByItemId(1003);
        inventory.displayAllItems();
        
        System.out.println("\nUpdated total inventory value: $" + inventory.calculateTotalValue());
    }
} 