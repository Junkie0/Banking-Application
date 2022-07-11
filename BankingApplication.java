package BankingApplication;
import java.util.Scanner;
import javax.xml.transform.Source;
import java.sql.SQLOutput;

public class BankingApplication {
    public static void main(String[] args) {
        BankAccount object1 = new BankAccount("Xyz", "Ba09");
        object1.showMenu();
    }
}
class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

//    Made an contructor here
    BankAccount(String cname, String cid){
        customerId = cid;
        customerName = cname;
    }

//    Methods
    void deposit(int amount){
        if(amount != 0){ // if the amount is not equal to zero then only perform this
            balance = balance + amount; // new account balance
            previousTransaction = amount; // update the previous transaction
        }
    }

    void withdraw(int amount){
        if(amount != 0){
            balance = balance - amount; // it will deduct the amount
            previousTransaction = -amount; // updat the previous transaction
        }
    }

    void getPreviousTransaction(){    // it will give the message if it's withdrawn or deposited
        if(previousTransaction > 0){
            System.out.println("Deposited: "+previousTransaction);
        }
        else if (previousTransaction < 0){
        System.out.println("withdrawn: "+Math.abs(previousTransaction));
//It will give Positive number instead of -ve
        }

        else {
            System.out.println("No transaction occoured");
            }
        }

    void showMenu(){
        char option = '\0'; // Initialize with 0
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " +customerName);
        System.out.println("Your ID " +customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction ");
        System.out.println("E. Exit");

        do{
            System.out.println("=================");
            System.out.println("Enter and option");
            System.out.println("=================");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option){
                case 'A':
                    System.out.println("---------------");
                    System.out.println(" Balance = "+balance);
                    System.out.println("----------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("----------------");
                    System.out.println("Enter an amount to deposit:");
                    System.out.println("----------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("-----------------");
                    System.out.println("Enter an amount to withdraw:");
                    System.out.println("------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("---------------");
                    getPreviousTransaction();
                    System.out.println("----------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("***********");
                    break;

                default:
                    System.out.println("Invalid Option!! Please enter again");
                    break;
            }
//            while(option != 'E');
//            System.out.println("Thank you for using our services");
        }
        while(option != 'E');
        System.out.println("Thank you for using our services");
    }

}
