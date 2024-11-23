import java.util.HashMap;
import java.util.Scanner;

public class ATMInterface {
    private static HashMap<Integer, Double> users = new HashMap<>(); // User PINs and their balances
    private static Scanner scanner = new Scanner(System.in);
    private static int currentUserPin;

    public static void main(String[] args) {
        initializeUsers(); // Set up user data
        System.out.println("Welcome to MyBank ATM!");

        authenticateUser(); // Authenticate the user before showing the menu

        while (true) {
            showMainMenu();
        

        }
    }

    private static void initializeUsers() {
        // Add user-specific PINs and balances
        users.put(1234, 5000.00); // User 1
        users.put(5678, 3000.00); // User 2
        users.put(9101, 10000.00); // User 3
    }

    private static void authenticateUser() {
        int attempts = 0; // To track login attempts
        while (attempts < 4) { // Allow up to 3 attempts
            System.out.print("Please enter your 4-digit PIN: ");
            int enteredPin = scanner.nextInt();
            if (users.containsKey(enteredPin)) {
                currentUserPin = enteredPin;
                System.out.println("Authentication successful!");
                return;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Try again.");
            }
        }
        System.out.println("Too many incorrect attempts. Exiting...");
        System.exit(0);
    }

    private static void showMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Exit");
        System.out.print("Please choose an option: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawCash();
                break;
            case 3:
                depositCash();
                break;
            case 4:
                System.out.println("Thank you for using MyBank ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void checkBalance() {
        double balance = users.get(currentUserPin);
        System.out.printf("Your current balance is: $%.2f\n", balance);
    }

    private static void withdrawCash() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        double balance = users.get(currentUserPin);

        if (amount > balance) {
            System.out.printf("Insufficient funds! Your current balance is $%.2f.\n", balance);
        } else if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            balance -= amount;
            users.put(currentUserPin, balance); // Update the user's balance
            System.out.printf("$%.2f withdrawn successfully. Remaining balance: $%.2f\n", amount, balance);
        }
    }

    private static void depositCash() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        double balance = users.get(currentUserPin);

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            balance += amount;
            users.put(currentUserPin, balance); // Update the user's balance
            System.out.printf("$%.2f deposited successfully. New balance: $%.2f\n", amount, balance);
        }
    }
}