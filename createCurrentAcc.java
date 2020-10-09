import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class createCurrentAcc 
{
	Random random = new Random();
	public int tID = 1000 + random.nextInt(3000);
	public static Date tdate;
	public static Log log;
	
	public static Current cacc;
	public static Mini_Statement ms;
	public static Transactions t = new Transactions();
	public static DatabaseConn dbc = new DatabaseConn();

	public static Scanner sc = new Scanner(System.in);
	public static int ch,ans=0;
	public static float amt;
	
	public createCurrentAcc() throws Exception
	{		
			System.out.println("---------- Current Account ----------");
			System.out.println("1.Create Account\n2.Deposite\n3.Withdraw\n4.OverDraft\n5.Mini-Statement");
			System.out.println("6.Update Details\n7.Display Details\n8.Delete Account\n9.Display All Accounts\n10.Exit");
			do
			{
				System.out.println("-------------------------------------");
				System.out.println("Enter Your Choice :-\t");
				ch = sc.nextInt();
				switch(ch)
				{
				case 1:
					System.out.println("-------------------------------------");
					System.out.println("Enter Account No., Customer Name, Account Balance, Company Name, Overdrafting Limit, Date Of Opening");
					cacc = new Current(sc.nextInt(),sc.next(),"Current",sc.nextFloat(),sc.next(),sc.nextFloat(),sc.next());
					dbc.storeAcc(cacc);
					ms.createFile(cacc.accNo);
					break;
				case 2:
					System.out.println("-------------------------------------");
					cacc = dbc.getCurrentAcc();
					System.out.println("Enter Amount To Be Deposite :-\t");
					amt = sc.nextFloat();
					if(t.deposite(cacc,amt))
					{
						log = createLog("Deposite");
						ms.appendFile(cacc.accNo,log);
						dbc.update(cacc);
					}
					break;
				case 3:
					System.out.println("-------------------------------------");
					cacc = dbc.getCurrentAcc();
					System.out.println("Enter Amount To Be Withdraw :-\t");
					amt = sc.nextFloat();
					if(t.withdraw(cacc,amt))
					{
						log = createLog("Withdraw");
						ms.appendFile(cacc.accNo,log);
						dbc.update(cacc);
					}
					break;
				case 4:
					System.out.println("-------------------------------------");
					cacc = dbc.getCurrentAcc();
					System.out.println("Enter Amount To Be Withdraw :-\t");
					float odamt = sc.nextFloat();
					if(cacc.overdraftlimit>=odamt && cacc.accBal<=odamt)
						cacc.overdrafting(odamt);
					else if(cacc.overdraftlimit < odamt)
						System.out.println("Overdraft Limit Exceeds...!");
					else
						System.out.println("Overdrafting Not Possible...!");
					log = createLog("Overdraft");
					ms.appendFile(cacc.accNo,log);
					dbc.update(cacc);
					break;
				case 5:
					cacc = dbc.getCurrentAcc();
					ms.readFile(cacc.accNo);
					break;
				case 6:
					System.out.println("-------------------------------------");
					cacc = dbc.getCurrentAcc();
					dbc.updateDetails(cacc);
					break;
				case 7:
					System.out.println("-------------------------------------");
					cacc = dbc.getCurrentAcc();
					System.out.println(cacc);
					break;
				case 8:
					System.out.println("-------------------------------------");
					cacc = dbc.getCurrentAcc();
					dbc.deleteAcc(cacc);
					ms.deleteFile(cacc.accNo);
					cacc = null;
					System.gc();
					break;
				case 9 :
					dbc.displayAllCurrentAcc();
					break;
				case 10:
					System.out.println("-------------------------------------");
					System.out.println("Thank You...!");
					break;
				default:
					System.out.println("Wronge Choice...!");					
				}
			}while(ch!=10);					
	}
	
	public Log createLog(String type)
	{
		tID = tID+1;
		tdate = new Date();  
		log = new Log(tID, type,tdate);
		return log;
	}

}
