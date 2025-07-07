class Book {
    String manuscriptTitle;
    int yearOfRelease;

    void displayInfo() {
        System.out.println("Title: " + manuscriptTitle + ", Year: " + yearOfRelease);
    }
}

class Author extends Book {
    String penName;
    String background;

    void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + penName + ", Bio: " + background);
    }
} 