import java.util.ArrayList;

public class LibraryAndBooks {
    private String name;
    private ArrayList<Book> books;

    public LibraryAndBooks(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Books in " + name + ":");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        LibraryAndBooks library1 = new LibraryAndBooks("City Library");
        LibraryAndBooks library2 = new LibraryAndBooks("University Library");

        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        library1.addBook(book1);
        library2.addBook(book2);
        library1.addBook(book2);

        library1.displayBooks();
        library2.displayBooks();
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}