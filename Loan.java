public class Loan extends Account
{
	final public String lDate;
	public float lAmount;
	public String lType;
	
	public Loan(int accNo, String custName, String accType, float accBal, String lDate, float lAmount, String lType) 
	{
		super(accNo, custName, accType, accBal);
		this.lDate = lDate;
		this.lAmount = lAmount;
		this.lType = lType;
	}

	public String getLoanDate()
	{
		return lDate;
	}

	public float getlAmount() 
	{
		return lAmount;
	}

	public String getlType()
	{
		return lType;
	}

	public void setlAmount(float lAmount) 
	{
		this.lAmount = lAmount;
	}
	
	public void payEMI(float amt)
	{
		setAccBal(getAccBal()-amt);
		setlAmount(lAmount-amt);
	}
	
	public float CalcInterest(float rate)
	{
		float IAmt = lAmount*rate/1200;
		return IAmt;
	}

	public void Display() 
	{
		super.Display();
		System.out.println("\nLoan Date:-\t\t"+lDate+"\nLoan Amount :-\t\t"+lAmount+"\nLoan Type :-\t\t"+lType);
	}
	
	
}
