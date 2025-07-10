package encapsulation;
abstract class LibraryItem {
    private String catalogNumber;
    private String itemTitle;
    private String creatorName;

    public LibraryItem(String catalogNumber, String itemTitle, String creatorName) {
        this.catalogNumber = catalogNumber;
        this.itemTitle = itemTitle;
        this.creatorName = creatorName;
    }

    public String getCatalogNumber() { return catalogNumber; }
    public String getItemTitle() { return itemTitle; }
    public String getCreatorName() { return creatorName; }

    abstract int getLoanDuration();
    
    void getItemDetails() {
        System.out.println("Catalog: " + catalogNumber + ", Title: " + itemTitle + ", Creator: " + creatorName);
    }
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private String borrowerInfo;

    public Book(String catalogNumber, String itemTitle, String creatorName, String borrowerInfo) {
        super(catalogNumber, itemTitle, creatorName);
        this.borrowerInfo = borrowerInfo;
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem() {
        System.out.println("Book reserved");
    }

    public boolean checkAvailability() {
        return borrowerInfo == null;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private String borrowerInfo;

    public Magazine(String catalogNumber, String itemTitle, String creatorName, String borrowerInfo) {
        super(catalogNumber, itemTitle, creatorName);
        this.borrowerInfo = borrowerInfo;
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem() {
        System.out.println("Magazine reserved");
    }

    public boolean checkAvailability() {
        return borrowerInfo == null;
    }
}

class DVD extends LibraryItem implements Reservable {
    private String borrowerInfo;

    public DVD(String catalogNumber, String itemTitle, String creatorName, String borrowerInfo) {
        super(catalogNumber, itemTitle, creatorName);
        this.borrowerInfo = borrowerInfo;
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem() {
        System.out.println("DVD reserved");
    }

    public boolean checkAvailability() {
        return borrowerInfo == null;
    }
} 