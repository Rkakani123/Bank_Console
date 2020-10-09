class ATM extends Account
{
	public int cardNo;
	public int cvv;
	public String cardExpDate;
	public float dLimit;
	
	
	public ATM(int accNo, String custName, float accBal, int cardNo, int cvv, String cardExpDate, float dLimit)
	{
		super(accNo, custName,"ATM", accBal);
		this.cardNo = cardNo;
		this.cvv = cvv;
		this.cardExpDate = cardExpDate;
		this.dLimit = dLimit;
	}


	@Override
	public String toString()
	{
		super.Display();
		return "\nCardNo :-\t\t"+cardNo+"\nCVV :-\t\t\t"+cvv+"\nCard Exp Date :-\t"+cardExpDate+"\nDaily Limit :-\t\t"+dLimit;
	}	

	

}
