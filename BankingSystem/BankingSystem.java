import java.util.*;
import one.*;

class Account {
    private String username;
    private String password;
    private double balance;
    private List<String> transactions;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: ₹" + amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawn: ₹" + amount);
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void showTransactions() {
        System.out.println("Transaction History:");
        for (String t : transactions) {
            System.out.println(t);
        }
    }
}

public class BankingSystem {
    private static List<Account> accounts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Thank you!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void register() {
        System.out.print("Enter username: ");
        String user = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        accounts.add(new Account(user, pass));
        System.out.println("Registration successful!");
    }

    private static void login() {
        System.out.print("Enter username: ");
        String user = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        for (Account acc : accounts) {
            if (acc.getUsername().equals(user) && acc.authenticate(pass)) {
                System.out.println("Login successful!");
                bankingMenu(acc);
                return;
            }
        }
        System.out.println("Invalid credentials!");
    }

    private static void bankingMenu(Account acc) {
        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Balance\n4. Transactions\n5. Logout");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount: ");
                    acc.deposit(sc.nextDouble());
                }
                case 2 -> {
                    System.out.print("Enter amount: ");
                    acc.withdraw(sc.nextDouble());
                }
                case 3 -> acc.checkBalance();
                case 4 -> acc.showTransactions();
                case 5 -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}