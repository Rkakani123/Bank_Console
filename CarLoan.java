public class CarLoan extends Loan
{
	public final int clNO;
	public float clInterest;
	public String carModel;
	
	public CarLoan(int accNo, String custName, String accType, float accBal, String lDate, float lAmount, String lType,
			int clNO, float clInterest, String carModel) 
	{
		super(accNo, custName, accType, accBal, lDate, lAmount, lType);
		this.clNO = clNO;
		this.clInterest = clInterest;
		this.carModel = carModel;
	}

	@Override
	public String toString() 
	{
		super.Display();
		return "\nCar Loan No.:-\t\t"+clNO+"\nCar Loan Interest :-\t"+clInterest+"\nCar Model :-\t\t"+carModel;
	}
	
	
	
}
