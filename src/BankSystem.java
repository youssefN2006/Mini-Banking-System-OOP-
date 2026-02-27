import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem
{
    Scanner sc=new Scanner(System.in);

    public void signup()
    {String name;
        System.out.println(ConsoleColors.BRIGHT_YELLOW+"Enter Name:");
       name=sc.nextLine();
        System.out.println("Enter Password:");
        String password;
        password=sc.nextLine();
        Account x=new Account(name,password);
        Filemanager.Accounts.add(x);
        System.out.println(ConsoleColors.BRIGHT_GREEN+"Account Created Successfully!"+ConsoleColors.Reset);
        x.display();
        Filemanager.save_accounts(Filemanager.Accounts);
    }//User enters all needed info and account is created
    public Account login()
    {
        int accattempts = 0;
        int passattempts = 0;

        Account accountfound = null;
        boolean accfound = false;
        boolean passcorrect = false;

        // Username loop
        while(accattempts < 3)
        {
            System.out.println("Enter Name:");
            String name = sc.nextLine();

            for(Account acc : Filemanager.Accounts)
            {
                if(acc.holdername.equals(name))
                {
                    accfound = true;
                    accountfound = acc;
                    break;
                }
            }

            if(!accfound)
            {
                System.out.println("Account name not found.");
                accattempts++;
            }
            else break;
        }

        if(!accfound)
            return null;

        // Password loop
        while(passattempts < 3)
        {
            System.out.println("Enter Password:");
            String password = sc.nextLine();

            if(accountfound.password.equals(password))
            {
                passcorrect = true;
                accountfound.display();
                return accountfound;
            }
            else
            {
                System.out.println("Wrong Password!");
                passattempts++;
            }
        }

        System.out.println("Too many failed attempts.");
        return null;
    }


}
