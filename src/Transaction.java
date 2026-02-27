import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
public class Transaction
{
Scanner sc=new Scanner(System.in);
int sendaccnum;
int recaccnum;
double amount;
String timestamp;
public Transaction(int s,int r,double a)
{
    sendaccnum=s;
    recaccnum=r;
    amount=a;
    timestamp = LocalDateTime.now().toString();
}


    public String toFileString()
    {
        return "Sender Account Number:"+this.sendaccnum+"||Receiver Account Number:"+this.recaccnum+"||Amount:"+this.amount+"||Time Stamp"+this.timestamp;
    }

}
