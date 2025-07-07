class BankAccount {
    String ledgerId;
    double availableFunds;
}

class SavingsAccount extends BankAccount {
    double annualYield;

    void displayAccountType() {
        System.out.println("Savings Account");
    }
}

class CheckingAccount extends BankAccount {
    int dailyCap;

    void displayAccountType() {
        System.out.println("Checking Account");
    }
}

class FixedDepositAccount extends BankAccount {
    int lockPeriod;

    void displayAccountType() {
        System.out.println("Fixed Deposit Account");
    }
} 