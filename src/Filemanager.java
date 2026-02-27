import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Filemanager
{
    Scanner sc = new Scanner(System.in);
    private static final String ACCOUNTS_FILE = "accounts";
    public static ArrayList<Account> Accounts = new ArrayList<>();
    File file = new File(ACCOUNTS_FILE);

    public static void save_accounts(ArrayList<Account> accounts)
    {

        try(BufferedWriter writer=new BufferedWriter(new FileWriter(ACCOUNTS_FILE)))
        {
            for(Account acc:Accounts)
            {
              writer.write( acc.accountno+","+acc.holdername+","+acc.password+","+ acc.balance);
              writer.newLine();
            }
        }
        catch (IOException e)
        {
         e.printStackTrace();
        }
    }
public static ArrayList<Account> loadaccounts()
{
    Accounts.clear();
    File file=new File(ACCOUNTS_FILE);
    if (!file.exists()) return Accounts;
    try(BufferedReader writer=new BufferedReader(new FileReader(ACCOUNTS_FILE)))
    {
     String line;
     while((line=writer.readLine())!=null)
     {
         String[] data=line.split(",");
         int accNo = Integer.parseInt(data[0]);
         String name = data[1];
         String pass = data[2];
         double balance = Double.parseDouble(data[3]);
         Account acc=new Account(name,pass);
         acc.accountno=accNo;
         acc.balance=balance;
         Accounts.add(acc);

     }
    }
    catch(IOException e)
    {
        System.out.println(ConsoleColors.BRIGHT_RED+"Error loading Account"+ConsoleColors.Reset);
    }
return Filemanager.Accounts;
}
    public static void saveTransaction(Transaction t) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("transactions.txt", true))) {
            bw.write(t.toFileString());
            bw.newLine();
        } catch(Exception e) {
            System.out.println(ConsoleColors.BRIGHT_RED+"Error saving transaction."+ConsoleColors.Reset);
        }
    }

}
