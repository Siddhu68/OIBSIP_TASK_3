import java.util.Scanner;
import java.util.ArrayList;

public class ATM_INTERFACE2 {
    public static ArrayList<String> list = new ArrayList<>();
    public static Scanner s = new Scanner(System.in);

    public static void login(String username, int pin) {
        if (username.contains("Jack") && pin == 1010) {
            list.add("Logged in");
            // ask();
        } else {
            System.out.println("Enter valid info!");
            System.out.print("Username followed by pin seperated with a space: ");
            login(s.next(), s.nextInt());
        }
    }

    public static void transfer(int balance, int amount) {
        if ((amount <= balance) && (amount >= 0)) {
            System.out.print("Enter reciver's username: ");
            String accname = s.next();
            balance -= amount;
            System.out.println(amount + " rupee/s sent to " + accname);
            System.out.println("Transaction successful, Current balance is " + balance);
            list.add(amount + " transfered to account " + accname);
        } else {
            System.out.print("Enter a valid amount(greater than equal to 0): ");
            transfer(balance, s.nextInt());
        }
    }

    public static void main(String args[]) {

        int balance = 0, withdraw, deposit;

        System.out.print("Enter user name: ");
        String username = s.next();
        System.out.print("Enter pin: ");
        int pin = s.nextInt();
        login(username, pin);
        while (true) {
            System.out.println("ATM\n");
            // System.out.println("Press 1 to Login\n");
            System.out.println("Press 1 to Withdraw\n");
            System.out.println("Press 2 to Deposit\n");
            System.out.println("Press 3 to Transfer\n");
            System.out.println("Press 4 to Check Balance\n");
            System.out.println("Press 5 to EXIT\n");
            System.out.print("Choose the operation you want to perform:");
            int menu = s.nextInt();
            switch (menu) {
                // case 1: {
                //     System.out.print("Enter user name: ");
                //     String username = s.next();
                //     System.out.print("Enter pin: ");
                //     int pin = s.nextInt();
                //     login(username, pin);
                //     break;
                // }
                case 1:
                    System.out.print("Enter money to be withdrawn:");
                    withdraw = s.nextInt();
                    if (balance >= withdraw) {
                        balance = balance - withdraw;
                        System.out.println("Please collect your money");
                        System.out.println("Balance : " + balance);
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                    System.out.println("");
                    break;

                case 2:
                    System.out.print("Enter money to be deposited:");
                    deposit = s.nextInt();
                    balance = balance + deposit;
                    System.out.println("Your Money has been successfully deposited");
                    System.out.println("Balance : " + balance);
                    System.out.println("");
                    break;

                case 3: {
                    System.out.print("Enter amount to be transfered: ");
                    int amount = s.nextInt();
                    transfer(balance, amount);
                    balance = balance-amount;
                    break;
                }
                case 4:
                    System.out.println("Balance : " + balance);
                    System.out.println("");
                    break;

                case 5:
                    System.out.println("Thankyou for using ATM!");
                    System.exit(0);
            }
        }
    }
}