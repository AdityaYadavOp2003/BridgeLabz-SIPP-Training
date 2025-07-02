package staticfinalthisinstanceof;

class BankAccount {
    
    static String bankName = "ABC Bank";
    static int totalAccounts = 0;

    
    private String accountHolderName;
    private final int accountNumber; 

    
    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    
    public static void getTotalAccounts() {
        System.out.println("Total Bank Accounts: " + totalAccounts);
    }

   
    public void displayDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }
}

public class BankAccountClass {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("John Doe", 1001);
        BankAccount acc2 = new BankAccount("Jane Smith", 1002);

       
        if (acc1 instanceof BankAccount) {
            acc1.displayDetails();
        }

        if (acc2 instanceof BankAccount) {
            acc2.displayDetails();
        }

        
        BankAccount.getTotalAccounts();
    }
}

