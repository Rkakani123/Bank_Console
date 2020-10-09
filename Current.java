public class Current extends Account
{
	public String compName;
	public float overdraftlimit;
	final String dateofopening;
	
	public Current(int accNo, String custName, String accType, float accBal, String compName, float overdraftlimit, String dateofopening)
	{
		super(accNo, custName, accType, accBal);
		this.compName = compName;
		this.overdraftlimit = overdraftlimit;
		this.dateofopening = dateofopening;
	}
	
	public void overdrafting(float overdraft)
	{
		setAccBal(getAccBal() - overdraft);
		System.out.println("Account Overdrafted...!");
	}
	
	@Override
	public String toString() 
	{
		return "Account No :-\t\t"+accNo+"\nCustomer Name :-\t"+custName+"\nAccount Type:-\t\t"+accType+"\nAccount Balance :-\t"+accBal+"\nCompany Name :-\t\t"+compName+"\nDate Of Opening :-\t"+dateofopening;
	}
	
	@Override
	protected void finalize() throws Throwable 
	{
		System.out.println("Hope You Liked The Service!!!");
	}
}
