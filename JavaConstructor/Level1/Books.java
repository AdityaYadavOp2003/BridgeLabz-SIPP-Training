

public class Books {
    String title;
    String author;
    int price;
    Books(){
        this.title="The Silent Patient";
        this.author="Alex Michaelides";
        this.price=550;
    }

    Books(String title, String author, int price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    void displayBooksDetails(){
        System.out.println("Book name:"+title);
        System.out.println("Author name:"+author);
        System.out.println("Books Price:"+price);
    }

    public static void main(String[] args) {
        Books b= new Books();
        b.displayBooksDetails();
        Books b2= new Books("the Hillman","Colen sed",450);
        b2.displayBooksDetails();
    }
}
