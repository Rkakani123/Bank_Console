import java.util.Date;
import java.util.Scanner;

public class Bank 
{
	public static int tID =100;
	public static Current cacc;
	public static HomeLoan HL;
	public static CarLoan CL;
	public static ATM atm;
	public static Mini_Statement ms;
	public static Transactions t = new Transactions();
	public static DatabaseConn dbc = new DatabaseConn();
	public static Log log;
	static Scanner sc = new Scanner(System.in);
	static int ch,ans=0;
	static float amt;
	
	
	public static void Loan()
	{
		System.out.println("---------- Loan Account ----------");
		do
		{
			System.out.println("1.Home Loan\n2.Car Loan\n3.Exit");
			System.out.println("Enter Your Choice :-\t");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				HomeLoan();
				break;			
			case 2:
				Carloan();
				break;
			case 3:
				System.out.println("Thank You...!");
				break;
			default:
				System.out.println("Wrong Choice...!");
			}
		}while(ch!=3);
	}
	
	public static void HomeLoan()
	{
		System.out.println("---------- Home Loan Account ----------");
		System.out.println("1.Create Account\n2.Calculate Interest\n3.Pay EMI\n4.Display\n5.Delete Account\n6.Exit");
		do
		{
			System.out.println("-------------------------------------");
			System.out.println("Enter Your Choice :-\t");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("-------------------------------------");
				System.out.println("Enter Account Number, Customer Name, Account Balance, Loan Issue Date, Loan Amount, Home Loan NO, Home Loan Interest, Carpetsize Of Home :-\t");
				HL = new HomeLoan(sc.nextInt(),sc.next(),"Loan",sc.nextFloat(),sc.next(),sc.nextFloat(),"Home",sc.nextInt(),sc.nextFloat(),sc.nextFloat());
				break;
			case 2:
				System.out.println("-------------------------------------");
				float amt =HL.CalcInterest(HL.hlInterest);
				HL.setlAmount(HL.getlAmount()+amt);
				System.out.println("Your Interest Is :-\t"+amt);
				break;
			case 3:
				System.out.println("-------------------------------------");
				System.out.println("Enter Amount To Pay :-\t");
				HL.payEMI(sc.nextFloat());
				System.out.println("EMI Paid...!");
				break;
			case 4:
				System.out.println("-------------------------------------");
				System.out.println(HL);
				break;
			case 5:
				System.out.println("-------------------------------------");
				HL = null;
				System.gc();
				ch=6;
				break;
			case 6:
				System.out.println("-------------------------------------");
				System.out.println("Thank You...!");
				break;
			default:
				System.out.println("Wrong Choice...!");				
			}
		}while(ch!=6);
	}
	
	public static void Carloan()
	{
		System.out.println("---------- Car Loan Account ----------");
		System.out.println("1.Create Account\n2.Calculate Interest\n3.Pay EMI\n4.Display\n5.Delete Account\n6.Exit");
		do
		{
			System.out.println("-------------------------------------");
			System.out.println("Enter Your Choice :-\t");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("-------------------------------------");
				System.out.println("Enter Account Number, Customer Name, Account Balance, Loan Issue Date, Loan Amount, Car Loan NO, Car Loan Interest, Car Model :-\t");
				CL = new CarLoan(sc.nextInt(),sc.next(),"Loan",sc.nextFloat(),sc.next(),sc.nextFloat(),"Home",sc.nextInt(),sc.nextFloat(),sc.next());
				break;
			case 2:
				System.out.println("-------------------------------------");
				float amt =CL.CalcInterest(CL.clInterest);
				CL.setlAmount(CL.getlAmount()+amt);
				System.out.println("Your Interest Is :-\t"+amt);
				break;
			case 3:
				System.out.println("-------------------------------------");
				System.out.println("Enter Amount To Pay :-\t");
				CL.payEMI(sc.nextFloat());
				System.out.println("EMI Paid...!");
				break;
			case 4:
				System.out.println("-------------------------------------");
				System.out.println(CL);
				break;
			case 5:
				System.out.println("-------------------------------------");
				CL = null;
				System.gc();
				ch=6;
				break;
			case 6:
				System.out.println("-------------------------------------");
				System.out.println("Thank You...!");
				break;
			default:
				System.out.println("Wrong Choice...!");				
			}
		}while(ch!=6);
	}
	
	public static void Atm()
	{
		System.out.println("---------- ATM Services ----------");
		System.out.println("1.Create Account\n2.Withdraw Amount\n3.Check Balance\n4.Display Mini-Statement\n5.Display Details\n6.Delete Account\n7.Exit");
		do
		{
			System.out.println("-------------------------------------");
			System.out.println("Enter Your Choice :-\t");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("-------------------------------------");
				System.out.println("Enter Account No., Customer Name, Account Balance, ATM Card No, CVV, ATM Card ExpDate, Daily Limit");
				atm = new ATM(sc.nextInt(),sc.next(),sc.nextFloat(),sc.nextInt(),sc.nextInt(),sc.next(),sc.nextInt());
				break;
			case 2:
				System.out.println("-------------------------------------");
				System.out.println("Enter Amount To Be Withdraw :-\t");
				amt = sc.nextFloat();
				if(t.withdraw(atm,amt))
				{
					tID = tID+1;
					Date tdate = new Date();  
					log = new Log(tID, "Withdraw",tdate);
					
				}
				break;
			case 3:
				System.out.println("-------------------------------------");
				System.out.println("Your Balance Is :-\t"+atm.getAccBal());
				break;
			case 4:
				System.out.println("-------------------------------------");
				System.out.println("TransID\tDescription\tTime");
				break;
			case 5:
				System.out.println("-------------------------------------");
				System.out.println(atm);
				break;
			case 6:
				System.out.println("-------------------------------------");
				atm = null;
				System.gc();
				ch=7;
			case 7:
				System.out.println("-------------------------------------");
				System.out.println("Thank You...!");
				break;
			default:
				System.out.println("Wronge Choice...!");					
			}
		}while(ch!=7);				
	}
	
}
