import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
void main()
{
    Filemanager.loadaccounts();
    BankSystem bank=new BankSystem();
    Scanner sc=new Scanner(System.in);
    System.out.println("Welcome To The Smart Banking System!" );
    while(true)
    {
        System.out.println("Please input the number of the function you wish to use:");
        System.out.println("1.SignUp");
        System.out.println("2.Login");
        System.out.println("3.Exit");
        int choice_1= sc.nextInt();
        if(choice_1==1)
        {
            bank.signup();
        }
        else if(choice_1==3)
        {
            System.out.println("Thank you for using our system!");
            break;
        }
        else if(choice_1==2)
        {
            Account Reciver=new Account();
            boolean userfound=false;
          Account current_user=bank.login();
          if(current_user!=null)
          {
              while(true) {
                  System.out.println("Please input the number of the function you wish to use:");
                  System.out.println("1.Deposit");
                  System.out.println("2.Withdraw");
                  System.out.println("3.Transfer");
                  System.out.println("4.Display");
                  System.out.println("5.Logout");
                  int choice_2 = sc.nextInt();
                  if (choice_2 == 1) {
                      current_user.deposit();
                      continue;
                  } else if (choice_2 == 2) {
                      current_user.withdraw();
                      continue;
                  } else if (choice_2 == 3) {
                      System.out.println("Enter Reciver account number:");
                      int recaccnum = sc.nextInt();
                      for (Account acc : Filemanager.Accounts) {
                          if (recaccnum == acc.accountno) {
                              System.out.println(ConsoleColors.BRIGHT_GREEN + "User Found" + ConsoleColors.Reset);
                              userfound = true;
                              Reciver = acc;

                          }
                      }
                      if (userfound == true) {
                          System.out.println("Enter Amount:");
                          double amount = sc.nextDouble();
                          current_user.Transfer(Reciver, amount);
                      }

                  } else if (choice_2 == 4) {
                      current_user.display();
                      continue;
                  } else if (choice_2 == 5) {
                      System.out.println("Thank you for using our system!");
                      break;
                  } else {
                      System.out.println(ConsoleColors.BRIGHT_RED + "Invalid Input!Please enter correct input" + ConsoleColors.Reset);
                      continue;
                  }
              }
          }
          else
          {


              System.out.println(ConsoleColors.BRIGHT_RED+"Invalid Input!Please enter correct input"+ConsoleColors.Reset);
              continue;

          }
        }


    }

}

