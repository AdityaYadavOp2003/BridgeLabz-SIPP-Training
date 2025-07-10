package encapsulation;
abstract class BankAccount {
    private String accountIdentifier;
    private String accountHolder;
    private double accountBalance;

    public BankAccount(String accountIdentifier, String accountHolder, double accountBalance) {
        this.accountIdentifier = accountIdentifier;
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
    }

    public String getAccountIdentifier() { return accountIdentifier; }
    public String getAccountHolder() { return accountHolder; }
    public double getAccountBalance() { return accountBalance; }

    public void deposit(double depositAmount) {
        accountBalance += depositAmount;
    }

    public void withdraw(double withdrawalAmount) {
        if (withdrawalAmount <= accountBalance) {
            accountBalance -= withdrawalAmount;
        }
    }

    abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan();
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accountIdentifier, String accountHolder, double accountBalance, double interestRate) {
        super(accountIdentifier, accountHolder, accountBalance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getAccountBalance() * interestRate;
    }

    public void applyForLoan() {
        System.out.println("Loan application submitted for savings account");
    }

    public boolean calculateLoanEligibility() {
        return getAccountBalance() > 10000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountIdentifier, String accountHolder, double accountBalance, double overdraftLimit) {
        super(accountIdentifier, accountHolder, accountBalance);
        this.overdraftLimit = overdraftLimit;
    }

    public double calculateInterest() {
        return getAccountBalance() * 0.02;
    }

    public void applyForLoan() {
        System.out.println("Loan application submitted for current account");
    }

    public boolean calculateLoanEligibility() {
        return getAccountBalance() > 5000;
    }
} 