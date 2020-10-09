public class Savings extends Account
{
	public String custUID;
	public String custAdd;
	final float interest = 3;

	public Savings(int accNo, String custName, String accType, float accBal, String custUID, String custAdd)
	{
		super(accNo, custName, accType, accBal);
		this.custUID = custUID;
		this.custAdd = custAdd;
	}

	public String getCustUID()
	{
		return custUID;
	}
	
	public float calcInterest()
	{
		float intamt = (getAccBal() * interest)/100;
		return intamt;
	}

	@Override
	public String toString() 
	{
		return "Account No :-\t\t"+accNo+"\nCustomer Name :-\t"+custName+"\nAccount Type:-\t\t"+accType+"\nCustomer Id :-\t\t"+custUID+"\nCustomer Address :-\t"+custAdd+"\nAccount Balance:-\t"+accBal;
	}

	@Override
	protected void finalize() throws Throwable 
	{
		System.out.println("Hope You Liked The Service!!!");
	}

	
}
