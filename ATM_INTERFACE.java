import java.util.Scanner;
// create a class named ATM
 class ATM {
// declare fields for the user's bank account
    private BankAccount account;
//    a scanner for user input
    private Scanner scan;
//    a flag for exiting the program
    private boolean exit;
   public ATM(BankAccount account) {
        this.account = account;
        scan = new Scanner(System.in);
        exit = false;
    }
    public void start() {
        System.out.println("Welcome to the ATM");
        System.out.println("Please enter your PIN:");
        int pin = scan.nextInt();
        // check if the PIN is correct
        if (pin == account.getPIN()) {
            // loop until the user chooses to exit
            while (!exit) {
                // display the menu of options
                System.out.println("Please choose an option:");
                System.out.println("1) Withdraw");
                System.out.println("2) Deposit");
                System.out.println("3) Check balance");
                System.out.println("4) Exit");
                // get the user's choice
                int choice = getChoice();
                // perform the corresponding operation
                switch (choice) {
                    case 1:
                        System.out.println("Enter the amount to withdraw:");
                        double amount = scan.nextDouble();
                        withdraw(amount);
                        break;
                    case 2:
                        System.out.println("Enter the amount to deposit:");
                        amount = scan.nextDouble();
                        deposit(amount);
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        exit();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        } else {
            // display an error message if the PIN is incorrect
            System.out.println("Wrong PIN. Access denied.");
        }
    }

    // create a method named getChoice() that returns an integer representing the user's choice from the menu
    public int getChoice() {
        // get the input from the user
        int choice = scan.nextInt();
        // validate the input and return it if it is between 1 and 4
        if (choice >= 1 && choice <= 4) {
            return choice;
        } else {
            // display an error message and ask for the input again if it is not valid
            System.out.println("Invalid option. Please enter a number between 1 and 4.");
            return getChoice();
        }
    }

    // create a method named withdraw() that takes an amount as a parameter and performs the withdrawal operation
    public void withdraw(double amount) {
        // check if the amount is positive and less than or equal to the available balance
        if (amount > 0 && amount <= account.getBalance()) {
            // deduct the amount from the balance and display a success message
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawal successful. Please collect your cash.");
        } else {
            // display an error message and ask for the input again if the amount is not valid
            System.out.println("Invalid amount. Please enter a positive amount that is less than or equal to your balance.");
            amount = scan.nextDouble();
            withdraw(amount);
        }
    }

    // create a method named deposit() that takes an amount as a parameter and performs the deposit operation
    public void deposit(double amount) {
        // check if the amount is positive
        if (amount > 0) {
            // add the amount to the balance and display a success message
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposit successful. Your new balance is " + account.getBalance());
        } else {
            // display an error message and ask for the input again if the amount is not valid
            System.out.println("Invalid amount. Please enter a positive amount.");
            amount = scan.nextDouble();
            deposit(amount);
        }
    }

    // create a method named checkBalance() that displays the current balance of the user's account
    public void checkBalance() {
        System.out.println("Your current balance is " + account.getBalance());
    }

    // create a method named exit() that sets the flag to true and displays a goodbye message
    public void exit() {
        exit = true;
        System.out.println("Thank you for using the ATM. Have a nice day.");
    }
}

// create a class named BankAccount that has fields for the account number, PIN, and balance
class BankAccount {
    // declare fields for the account number, PIN, and balance
    private int accountNumber;
    private int PIN;
    private double balance;

    // create a constructor for the BankAccount class that takes the account number, PIN, and balance as parameters and initializes the fields
    public BankAccount(int accountNumber, int PIN, double balance) {
        this.accountNumber = accountNumber;
        this.PIN = PIN;
        this.balance = balance;
    }

    // create getters and setters for the fields of the BankAccount class
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

// create a main method that creates a BankAccount object with some initial values and passes it to an ATM object
// call the start() method of the ATM object to begin the program
public class ATM_INTERFACE {
    public static void main(String[] args) {
        // create a BankAccount object with some initial values
        BankAccount account = new BankAccount(123456789, 1234, 10000.0);
        // create an ATM object and pass the BankAccount object to it
        ATM atm = new ATM(account);
        // call the start() method of the ATM object to begin the program
        atm.start();
    }
}
