package JavaClassAndObject.Level2;

class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    BankAccount(String holder, String accNum, double initialBalance) {
        this.accountHolder = holder;
        this.accountNumber = accNum;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Priya", "ACC123", 10000);
        acc.deposit(2000);
        acc.withdraw(5000);
        acc.displayBalance();
    }
}
