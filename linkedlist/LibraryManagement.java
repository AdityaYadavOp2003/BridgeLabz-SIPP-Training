package linkedlist;
import java.util.ArrayList;
import java.util.List;

class BookNode {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;
    
    BookNode(String bookTitle, String author, String genre, int bookId) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = true;
        this.next = null;
        this.prev = null;
    }
}

class LibraryLinkedList {
    private BookNode head;
    private BookNode tail;
    private int bookCount;
    
    LibraryLinkedList() {
        this.head = null;
        this.tail = null;
        this.bookCount = 0;
    }
    
    void addAtBeginning(String bookTitle, String author, String genre, int bookId) {
        BookNode newBook = new BookNode(bookTitle, author, genre, bookId);
        if (this.head == null) {
            this.head = newBook;
            this.tail = newBook;
        } else {
            newBook.next = this.head;
            this.head.prev = newBook;
            this.head = newBook;
        }
        this.bookCount++;
    }
    
    void addAtEnd(String bookTitle, String author, String genre, int bookId) {
        BookNode newBook = new BookNode(bookTitle, author, genre, bookId);
        if (this.head == null) {
            this.head = newBook;
            this.tail = newBook;
        } else {
            newBook.prev = this.tail;
            this.tail.next = newBook;
            this.tail = newBook;
        }
        this.bookCount++;
    }
    
    void addAtPosition(int position, String bookTitle, String author, String genre, int bookId) {
        if (position <= 0) {
            addAtBeginning(bookTitle, author, genre, bookId);
            return;
        }
        
        if (position >= this.bookCount) {
            addAtEnd(bookTitle, author, genre, bookId);
            return;
        }
        
        BookNode newBook = new BookNode(bookTitle, author, genre, bookId);
        BookNode current = this.head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        
        newBook.prev = current.prev;
        newBook.next = current;
        current.prev.next = newBook;
        current.prev = newBook;
        this.bookCount++;
    }
    
    boolean removeByBookId(int bookId) {
        if (this.head == null) {
            return false;
        }
        
        BookNode current = this.head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current == this.head) {
                    this.head = current.next;
                    if (this.head != null) {
                        this.head.prev = null;
                    } else {
                        this.tail = null;
                    }
                } else if (current == this.tail) {
                    this.tail = current.prev;
                    this.tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                this.bookCount--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    List<BookNode> searchByTitle(String title) {
        List<BookNode> results = new ArrayList<>();
        BookNode current = this.head;
        while (current != null) {
            if (current.bookTitle.toLowerCase().contains(title.toLowerCase())) {
                results.add(current);
            }
            current = current.next;
        }
        return results;
    }
    
    List<BookNode> searchByAuthor(String author) {
        List<BookNode> results = new ArrayList<>();
        BookNode current = this.head;
        while (current != null) {
            if (current.author.toLowerCase().contains(author.toLowerCase())) {
                results.add(current);
            }
            current = current.next;
        }
        return results;
    }
    
    boolean updateAvailability(int bookId, boolean isAvailable) {
        BookNode current = this.head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    void displayForward() {
        if (this.head == null) {
            System.out.println("No books in the library");
            return;
        }
        
        BookNode current = this.head;
        while (current != null) {
            String status = current.isAvailable ? "Available" : "Not Available";
            System.out.println("ID: " + current.bookId + ", Title: " + current.bookTitle + 
                             ", Author: " + current.author + ", Genre: " + current.genre + 
                             ", Status: " + status);
            current = current.next;
        }
    }
    
    void displayReverse() {
        if (this.tail == null) {
            System.out.println("No books in the library");
            return;
        }
        
        BookNode current = this.tail;
        while (current != null) {
            String status = current.isAvailable ? "Available" : "Not Available";
            System.out.println("ID: " + current.bookId + ", Title: " + current.bookTitle + 
                             ", Author: " + current.author + ", Genre: " + current.genre + 
                             ", Status: " + status);
            current = current.prev;
        }
    }
    
    int getTotalBookCount() {
        return this.bookCount;
    }
    
    int getAvailableBookCount() {
        int availableCount = 0;
        BookNode current = this.head;
        while (current != null) {
            if (current.isAvailable) {
                availableCount++;
            }
            current = current.next;
        }
        return availableCount;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        LibraryLinkedList library = new LibraryLinkedList();
        
        library.addAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1001);
        library.addAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 1002);
        library.addAtPosition(1, "1984", "George Orwell", "Dystopian", 1003);
        library.addAtEnd("Pride and Prejudice", "Jane Austen", "Romance", 1004);
        library.addAtEnd("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1005);
        
        System.out.println("All books in forward order:");
        library.displayForward();
        
        System.out.println("\nAll books in reverse order:");
        library.displayReverse();
        
        System.out.println("\nTotal books in library: " + library.getTotalBookCount());
        System.out.println("Available books: " + library.getAvailableBookCount());
        
        System.out.println("\nSearching for books by title containing 'The':");
        List<BookNode> titleResults = library.searchByTitle("The");
        for (BookNode book : titleResults) {
            System.out.println("Found: " + book.bookTitle + " by " + book.author);
        }
        
        System.out.println("\nSearching for books by author 'Jane Austen':");
        List<BookNode> authorResults = library.searchByAuthor("Jane Austen");
        for (BookNode book : authorResults) {
            System.out.println("Found: " + book.bookTitle);
        }
        
        System.out.println("\nUpdating availability for book 1001:");
        library.updateAvailability(1001, false);
        library.displayForward();
        
        System.out.println("\nAvailable books: " + library.getAvailableBookCount());
        
        System.out.println("\nRemoving book with ID 1003:");
        library.removeByBookId(1003);
        library.displayForward();
        
        System.out.println("\nUpdated total books: " + library.getTotalBookCount());
    }
} 