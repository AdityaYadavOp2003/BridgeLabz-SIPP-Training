package encapsulation;
abstract class Product {
    private String merchandiseCode;
    private String merchandiseName;
    private double merchandisePrice;

    public Product(String merchandiseCode, String merchandiseName, double merchandisePrice) {
        this.merchandiseCode = merchandiseCode;
        this.merchandiseName = merchandiseName;
        this.merchandisePrice = merchandisePrice;
    }

    public String getMerchandiseCode() { return merchandiseCode; }
    public String getMerchandiseName() { return merchandiseName; }
    public double getMerchandisePrice() { return merchandisePrice; }

    abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    private double warrantyCost;

    public Electronics(String merchandiseCode, String merchandiseName, double merchandisePrice, double warrantyCost) {
        super(merchandiseCode, merchandiseName, merchandisePrice);
        this.warrantyCost = warrantyCost;
    }

    public double calculateDiscount() {
        return getMerchandisePrice() * 0.15;
    }

    public double calculateTax() {
        return getMerchandisePrice() * 0.18;
    }

    public String getTaxDetails() {
        return "GST: " + calculateTax();
    }
}

class Clothing extends Product implements Taxable {
    private String fabricType;

    public Clothing(String merchandiseCode, String merchandiseName, double merchandisePrice, String fabricType) {
        super(merchandiseCode, merchandiseName, merchandisePrice);
        this.fabricType = fabricType;
    }

    public double calculateDiscount() {
        return getMerchandisePrice() * 0.10;
    }

    public double calculateTax() {
        return getMerchandisePrice() * 0.12;
    }

    public String getTaxDetails() {
        return "GST: " + calculateTax();
    }
}

class Groceries extends Product {
    private String expiryDate;

    public Groceries(String merchandiseCode, String merchandiseName, double merchandisePrice, String expiryDate) {
        super(merchandiseCode, merchandiseName, merchandisePrice);
        this.expiryDate = expiryDate;
    }

    public double calculateDiscount() {
        return getMerchandisePrice() * 0.05;
    }
} 