package JavaConstructor.Level1;

public class Book {
    String title;
    String author;
    double price;
    boolean available;

    public Book(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("You have successfully borrowed: " + title);
        } else {
            System.out.println("Sorry, "+title+" is already borrowed.");
        }
    }

    public void displayBook() {
        System.out.println(title+" by "+author + " - "+price+" ["+(available ? "Available" : "Not Available")+"]");
    }

    public static void main(String[] args) {
        Book b1 = new Book("Atomic Habits", "James Clear", 450, true);
        b1.displayBook();
        b1.borrowBook();
        b1.borrowBook();
    }
}
