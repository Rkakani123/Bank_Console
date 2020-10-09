public class Transactions
{
	public Boolean deposite(Account a, float amt) 
	{
			if(amt<0)
			{
				System.out.println("Negative Amount...!");
				return false;
			}
			else
			{
				a.setAccBal(a.accBal+amt);
			}
			System.out.println("Balance:-\t"+a.getAccBal());
			return true;
	}
	
	public Boolean withdraw(Account a, float amt) 
	{
		if(amt<0)
		{
			System.out.println("Negative Amount...!");
		}
		else if(a.accBal<=1000 && a.getAccType().equals("Savings"))
		{
			System.out.println("InSufficient Funds...!");
		}
		else if (a.accBal<=amt && (a.getAccType().equals("Savings")|| (a.getAccType().equals("ATM"))))
		{
			System.out.println("InSufficient Funds...!");
		}
		else
		{
			a.setAccBal(a.accBal-amt);
			System.out.println("Balance:-\t"+a.getAccBal());
			return true;
		}	
		return false;
	}
}
