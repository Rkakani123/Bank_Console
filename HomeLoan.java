public class HomeLoan extends Loan
{
	public final int hlNO;
	public float hlInterest;
	public float carpetsize;
	
	public HomeLoan(int accNo, String custName, String accType, float accBal, String lDate, float lAmount, String lType,
			int hlNO, float hlInterest, float carpetsize) 
	{
		super(accNo, custName, accType, accBal, lDate, lAmount, lType);
		this.hlNO = hlNO;
		this.hlInterest = hlInterest;
		this.carpetsize = carpetsize;
	}

	@Override
	public String toString() 
	{
		super.Display();
		return "\nHome Loan No.:-\t\t"+hlNO+"\nHome Loan Interest :-\t"+hlInterest+"\nCarpet Size Of Home :-\t"+carpetsize;
	}
	
	
	
}
