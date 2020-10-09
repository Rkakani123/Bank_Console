import java.util.Date;

public class Log 
{
	public int tID;
	public String tMsg;
	public Date tdate;
	
	public Log(int tID, String tMsg, Date tdate) 
	{
		this.tID = tID;
		this.tMsg = tMsg;
		this.tdate = tdate;
	}
	

	public int gettID() {
		return tID;
	}


	public String gettMsg() {
		return tMsg;
	}


	public Date getTdate() {
		return tdate;
	}


	@Override
	public String toString()
	{
		return tID+"\t"+tMsg+"\t"+tdate;
	}
	
	
	
}
