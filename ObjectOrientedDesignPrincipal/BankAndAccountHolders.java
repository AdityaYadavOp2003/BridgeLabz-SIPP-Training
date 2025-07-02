import java.util.ArrayList;
import java.util.List;

public class BankAndAccountHolders{
    private String bankName;
    private List<Customer> customers;

    public BankAndAccountHolders(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public void openAccount(String customerName) {
        Customer customer = new Customer(customerName);
        customers.add(customer);
    }

    public void displayCustomers() {
        System.out.println("Customers of " + bankName + ":");
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }
    }

    public static void main(String[] args) {
        BankAndAccountHolders bank = new BankAndAccountHolders("National Bank");
        bank.openAccount("Alice Johnson");
        bank.openAccount("Bob Smith");
        bank.displayCustomers();
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}