import java.util.*;

public class createSavingAcc 
{
	Random random = new Random();
	public int tID = 1000 + random.nextInt(3000);
	public static Date tdate;
	public static Log log;
	
	public static Savings sacc;
	public static Mini_Statement ms;
	public static Transactions t = new Transactions();
	public static DatabaseConn dbc = new DatabaseConn();
	
	public static Scanner sc = new Scanner(System.in);
	public static int ch,ans=0;
	public static float amt;
	
	public createSavingAcc() throws Exception
	{
		System.out.println("---------- Saving Account ----------");
		System.out.println("1.Create Account\n2.Deposite\n3.Withdraw\n4.Calculate Interest\n5.Mini-Statement");
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
				System.out.println("Enter Account No., Customer Name, Account Balance, Customer ID, Customer Address");
				sacc = new Savings(sc.nextInt(),sc.next(),"Savings",sc.nextFloat(),sc.next(),sc.next());
				dbc.storeAcc(sacc);
				ms.createFile(sacc.accNo);
				break;
			case 2:
				System.out.println("-------------------------------------");
				sacc = dbc.getSavingAcc();
				System.out.println("Enter Amount To Be Deposite :-\t");
				amt = sc.nextFloat();
				if(t.deposite(sacc,amt))
				{
					log = createLog("Deposite");
					ms.appendFile(sacc.getAccNo(), log);
					dbc.update(sacc);
				}
				break;
			case 3:
				System.out.println("-------------------------------------");
				sacc = dbc.getSavingAcc();
				System.out.println("Enter Amount To Be Withdraw :-\t");
				amt = sc.nextFloat();
				if(t.withdraw(sacc,amt))
				{
					log = createLog("Withdraw");
					ms.appendFile(sacc.getAccNo(), log);
					dbc.update(sacc);
				}
				break;
			case 4:
				System.out.println("-------------------------------------");
				sacc = dbc.getSavingAcc();
				float interestamt = sacc.calcInterest();
				System.out.println("Interest Calculated :-\t"+interestamt);
				sacc.setAccBal(sacc.accBal+interestamt);
				log = createLog("Intrest");
				ms.appendFile(sacc.getAccNo(), log);
				dbc.update(sacc);
				break;
			case 5:
				System.out.println("-------------------------------------");
				sacc = dbc.getSavingAcc();
				ms.readFile(sacc.accNo);
				break;
			case 6:
				System.out.println("-------------------------------------");
				sacc = dbc.getSavingAcc();
				dbc.updateDetails(sacc);
				break;
			case 7:
				System.out.println("-------------------------------------");
				sacc = dbc.getSavingAcc();
				System.out.println(sacc);
				break;
			case 8:
				System.out.println("-------------------------------------");
				sacc = dbc.getSavingAcc();
				dbc.deleteAcc(sacc);
				ms.deleteFile(sacc.accNo);
				break;
			case 9:
				dbc.displayAllSavingAcc();
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
