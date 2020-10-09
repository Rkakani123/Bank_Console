import java.util.Scanner;

public class TestBank
{
	public static void main(String[] args) throws Exception
	{
		int ch;
		Scanner sc = new Scanner(System.in);
		Bank b = new Bank();
		do
		{
			System.out.println("***** WELCOME TO YES BANK *****");
			System.out.println("--------------- MENU ---------------");
			System.out.println("1.Saving Account\n2.Current Account\n3.Loan Accounts\n4.ATM Service\n5.Feedback&Complaint\n6.Exit\nEnter Your Choice:-\t");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				createSavingAcc SA = new createSavingAcc();
				Thread.sleep(2000);
				break;
			case 2:
				createCurrentAcc CA = new createCurrentAcc();
				Thread.sleep(2000);
				break;
			case 3:
				b.Loan();
				break;
			case 4:
				b.Atm();
				break;
			case 5:
				System.out.println("Enter Your Feedback & Complaint :-\t");
				String feedback = sc.next();
				System.out.println("We Will Try To Improve Our Service On The Basis Of Your Feed.... \nThank YOu...!");
				break;
			case 6:
				break;
			default:
				System.out.println("Wrong Choice...!");				
			}
		}while(ch!=6);
	}		
}
