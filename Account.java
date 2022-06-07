import java.util.Scanner;

public class Account {
    //Account Variables
    int balance;
    int previousTransaction;

    String customerName;
    String customerID;

    //Class Constructor
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    // Deposit Money
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    // Withdrawing Money
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    // Show Previous Transaction
    void getPreviousTransaction(){
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        }
        else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transaction has occured.");
        }
    }

    //Function calculating interest of current funds after a number of years
    void calculateInterest(int years){
        double interestRate = 0.0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate));
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    // Show Main Menu
    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                // Checks balance for user
                case 'A':
                    System.out.println("================================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("================================");
                    System.out.println();
                    break;
                // Allows user to deposit money
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
               // Allows user to withdraw money
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                // View most recent transaction
                case 'D':
                    System.out.println("================================");
                    getPreviousTransaction();
                    System.out.println("================================");
                    System.out.println();
               // Calculates accrued interest
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
               // Exists user from their account
                case 'F':
                    System.out.println("================================");
                    break;
               // Invalid character input
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E, F");
                    break;
            }
        } while(option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}


