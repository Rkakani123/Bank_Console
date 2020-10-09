public class Account 
{
	public int accNo;
	public String custName;
	public String accType;
	public float accBal;
		
	public Account(int accNo, String custName, String accType, float accBal) 
	{
		this.accNo = accNo;
		this.custName = custName;
		this.accType = accType;
		this.accBal = accBal;
	}

	public int getAccNo() 
	{
		return accNo;
	}

	public String getCustName() 
	{
		return custName;
	}

	public String getAccType() 
	{
		return accType;
	}

	public float getAccBal()
	{
		return accBal;
	}

	public void setAccBal(float accBal) 
	{
		this.accBal = accBal;
	}

	public void Display()
	{
		System.out.println("Account No :-\t\t"+accNo+"\nCustomer Name :-\t"+custName+"\nAccount Type:-\t\t"+accType+"\nAccount Balance :-\t"+accBal);
	}
	
	
	
}
