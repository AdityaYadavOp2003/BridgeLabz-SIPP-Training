package staticfinalthisinstanceof;

class Book {
    static String libraryName = "City Central Library";
    private String title;
    private String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayDetails() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN  : " + isbn);
    }
}

public class BookClass {
    public static void main(String[] args) {
        Book book1 = new Book("The Alchemist", "Paulo Coelho", "ISBN12345");
        Book book2 = new Book("1984", "George Orwell", "ISBN67890");

        if (book1 instanceof Book) {
            book1.displayDetails();
        }

        if (book2 instanceof Book) {
            book2.displayDetails();
        }

        Book.displayLibraryName();
    }
}
