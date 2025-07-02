package JavaConstructor.Level2;

public class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(2001, "Sneha", 15000.0);

        sa.showAccountInfo();
        System.out.println("Balance: ₹" + sa.getBalance());

        sa.setBalance(20000.0);
        System.out.println("Updated Balance: ₹" + sa.getBalance());
    }

}

class SavingsAccount extends BankAccount {
    public SavingsAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void showAccountInfo() {
        System.out.println("Account Number: " + accountNumber); // public
        System.out.println("Account Holder: " + accountHolder); // protected
    }
}

