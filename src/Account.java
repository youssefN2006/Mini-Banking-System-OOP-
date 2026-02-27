import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Account {
    static int accountcounter = 0;//This is Account counter to assign ID
    String holdername;//Account Holder Name
    double balance;//Every Account must start with a balance 0.0
    String password;
    int accountno;//Account ID
    Scanner sc = new Scanner(System.in);

    public Account() {
    }

    public Account(String holdername, String password) {
        accountcounter++;
        this.accountno = accountcounter;
        this.balance = 0;
        this.holdername = holdername;
        this.password = password;
    }//Account constructor

    public void display() {
        System.out.println(ConsoleColors.CYAN + "Holder Name:" + this.holdername + " Account Number:" + this.accountno + " Balance:" + this.balance + ConsoleColors.Reset);
    }//Displays Account info

    void deposit() {
        System.out.println("Enter Amount:");
        double amount = sc.nextDouble();
        balance = balance + amount;
        System.out.println(ConsoleColors.BRIGHT_GREEN + "Amount Deposited!" + ConsoleColors.Reset);
        Filemanager.save_accounts(Filemanager.Accounts);

    }//Deposits Amount into account

    void withdraw() {
        System.out.println("Enter Amount:");
        double amount = sc.nextDouble();
        if (amount > balance) {
            System.out.println(ConsoleColors.BRIGHT_RED + "Amount too large.Please withdraw a smaller amount." + ConsoleColors.Reset);
        } else {
            balance = balance - amount;
            System.out.println(ConsoleColors.BRIGHT_GREEN+"Amount Withdrawn"+ConsoleColors.Reset);
            Filemanager.save_accounts(Filemanager.Accounts);
        }
    }//Withdrawing of amount aslong as less than balance

    public boolean Transfer(Account receiver, double amount) {
        if(amount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }

        if(amount > this.balance) {
            System.out.println("Insufficient balance.");
            return false;
        }

        this.balance -= amount;
        receiver.balance += amount;
        Filemanager.save_accounts(Filemanager.Accounts);
        // Create transaction and save it
        Transaction t = new Transaction(this.accountno, receiver.accountno, amount);
        Filemanager.saveTransaction(t);
        System.out.println("Transfer successful!");
        return true;
    }
}