class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    
    BankAccount(int accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0;
    }

    
    BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful: Rs. " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful: Rs. " + amount);
        }
    }

   
    void displayBalance() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Available Balance: Rs. " + balance);
    }
}

public class Main {
    public static void main(String[] args) {

        
        BankAccount a1 = new BankAccount(1001, "Aamir");
        BankAccount a2 = new BankAccount(1002, "Sara", 5000);

        a1.deposit(2000);
        a2.withdraw(1500);

        // Displaying updated balances
        a1.displayBalance();
        a2.displayBalance();
    }
}