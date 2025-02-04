package bankaccounttest;

/**
 * Class representing a bank account with basic operations such as deposit and withdrawal.
 */
public class BankAccount {
    private double balance;

    /**
     * Creates a bank account with an initial balance.
     * 
     * @param initialBalance The initial balance (must not be negative).
     * @throws IllegalArgumentException if the initial balance is negative or invalid.
     */
    public BankAccount(double initialBalance) {
        if (Double.isNaN(initialBalance) || Double.isInfinite(initialBalance)) {
            throw new IllegalArgumentException("Initial balance must be a valid number.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    /**
     * Deposits money into the account.
     * 
     * @param amount The amount to deposit (must be greater than 0 and valid).
     * @throws IllegalArgumentException if the deposit amount is invalid.
     */
    public synchronized void deposit(double amount) {
        if (Double.isNaN(amount) || Double.isInfinite(amount)) {
            throw new IllegalArgumentException("Deposit amount must be a valid number.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.");
        }
        balance += amount;
    }

    /**
     * Withdraws money from the account.
     * 
     * @param amount The amount to withdraw (must be greater than 0 and not exceed the balance).
     * @throws IllegalArgumentException if the withdrawal amount is invalid.
     */
    public synchronized void withdraw(double amount) {
        if (Double.isNaN(amount) || Double.isInfinite(amount)) {
            throw new IllegalArgumentException("Withdrawal amount must be a valid number.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Withdrawal amount exceeds the current balance.");
        }
        balance -= amount;
    }

    /**
     * Returns the current balance of the account.
     * 
     * @return The current balance.
     */
    public synchronized double getBalance() {
        return balance;
    }
}
