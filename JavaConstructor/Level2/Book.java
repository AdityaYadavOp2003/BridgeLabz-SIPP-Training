package JavaConstructor.Level2;

public class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public static void main(String[] args) {
        EBook ebook = new EBook("ISBN123", "Digital Fortress", "Dan Brown");

        ebook.display();
        System.out.println("Author: " + ebook.getAuthor());

        ebook.setAuthor("D. Brown");
        System.out.println("Updated Author: " + ebook.getAuthor());
    }

}

class EBook extends Book {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void display() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
//        System.out.println("Author: " + author);
    }
}
