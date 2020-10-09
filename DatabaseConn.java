import java.sql.*;
import java.util.Scanner;

public class DatabaseConn
{
	public static Savings sacc;
	public static Current cacc;
	public static Connection conn;
	public static Scanner sc= new Scanner(System.in);
	
	public DatabaseConn()
	{		
		try 
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Rkakani");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void storeAcc(Account a) throws SQLException
	{
		if(a instanceof Savings)
		{
			Savings obj =(Savings)a;	
			PreparedStatement ps = conn.prepareStatement("Insert into savings values(?,?,?,?,?,?)");
			ps.setInt(1,obj.getAccNo());
			ps.setString(2,obj.getCustName());
			ps.setString(3,obj.accType);
			ps.setFloat(4,obj.getAccBal());
			ps.setString(5,obj.getCustUID());
			ps.setString(6,obj.custAdd);
			int i = ps.executeUpdate();
			if(i>0)
				System.out.println("Record Inserted Into Database...!");
		}
		
		if(a instanceof Current)
		{
			Current obj =(Current)a;	
			PreparedStatement ps = conn.prepareStatement("Insert into current values(?,?,?,?,?,?,?)");
			ps.setInt(1,obj.getAccNo());
			ps.setString(2,obj.getCustName());
			ps.setString(3,obj.accType);
			ps.setFloat(4,obj.getAccBal());
			ps.setString(5,obj.compName);
			ps.setFloat(6,obj.overdraftlimit);
			ps.setString(7,obj.dateofopening);
			int i = ps.executeUpdate();
			if(i>0)
				System.out.println("Record Inserted Into Database...!");
		}
	
	}
	
	public static void update(Account a) throws Exception
	{
		if(a instanceof Savings)
		{
			Savings obj = (Savings)a;
			PreparedStatement ps = conn.prepareStatement("update savings set Balance = ? where AccNo= ?");
			ps.setFloat(1, obj.getAccBal());
			ps.setInt(2, obj.getAccNo());
			int i = ps.executeUpdate();
			if(i>0)
				System.out.println("Updated Into Database...!");
		}
		if(a instanceof Current)
		{
			Current obj = (Current)a;
			PreparedStatement ps = conn.prepareStatement("update current set Balance = ? where AccNo= ?");
			ps.setFloat(1, obj.getAccBal());
			ps.setInt(2, obj.getAccNo());
			int i = ps.executeUpdate();
			if(i>0)
				System.out.println("Updated Into Database...!");
		}
	}
	
	public static void deleteAcc(Account a) throws Exception
	{
		if(a instanceof Savings)
		{
			PreparedStatement ps = conn.prepareStatement("delete from savings where AccNo = ?");
			ps.setInt(1,a.getAccNo());
			int i = ps.executeUpdate();
			if(i>0)
				System.out.println("Deleted From Database...!");
		}
		if(a instanceof Current)
		{
			PreparedStatement ps = conn.prepareStatement("delete from current where AccNo = ?");
			ps.setInt(1,a.getAccNo());
			int i = ps.executeUpdate();
			if(i>0)
				System.out.println("Deleted From Database...!");
		}
	}
	
	public static Savings getSavingAcc() throws Exception
	{
		PreparedStatement ps = conn.prepareStatement("select * from savings where AccNo = ?");
		System.out.println("Enter Account Number :-\t");
		Scanner sc = new Scanner(System.in);
		ps.setInt(1,sc.nextInt());
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		sacc = new Savings(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5),rs.getString(6));
		return sacc;
	}
	
	public static Current getCurrentAcc() throws Exception
	{
		PreparedStatement ps = conn.prepareStatement("select * from current where AccNo = ?");
		System.out.println("Enter Account Number :-\t");
		Scanner sc = new Scanner(System.in);
		ps.setInt(1,sc.nextInt());
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		cacc = new Current(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5),rs.getFloat(6),rs.getString(7));
		return cacc;
	}
	
	public static void displayAllSavingAcc() throws Exception
	{
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from savings");
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println("-------------------------------------------------------------------------------");
		for(int i=1;i<=rsmd.getColumnCount();i++)
		{
			if(i==4)
				System.out.print(rsmd.getColumnName(i)+"\t\t");
			else
			System.out.print(rsmd.getColumnName(i)+"\t");
		}

		System.out.println("\n-------------------------------------------------------------------------------");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getFloat(4)+"\t\t"+rs.getString(5)+"\t"+rs.getString(6));
		}		
		System.out.println("-------------------------------------------------------------------------------");
	}
	
	public static void displayAllCurrentAcc() throws Exception
	{
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from current");
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		for(int i=1;i<=rsmd.getColumnCount();i++)
		{
			if(i==4 || i==5)
				System.out.print(rsmd.getColumnName(i)+"\t\t");
			else
				System.out.print(rsmd.getColumnName(i)+"\t");
		}
		
		System.out.println("\n------------------------------------------------------------------------------------------------------------------");
		while(rs.next())
		{
			System.out.println("\n"+rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getFloat(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getFloat(6)+"\t\t"+rs.getString(7));
		}		
		System.out.println("------------------------------------------------------------------------------------------------------------------");
	}
	
	public static void updateDetails(Account a)
	{
		try
		{
			int i=0;
			if(a instanceof Savings)
			{
				Savings obj = (Savings)a;
				PreparedStatement ps = conn.prepareStatement("update savings set ? = ? where AccNo= ?");
				System.out.println("Change 1.UID or 2.Address");
				int ch = sc.nextInt();
				switch(ch)
				{
				case 1:
					System.out.println("Enter New UID :-\t");
					ps.setString(1,"UID");
					ps.setString(2,sc.next());
					ps.setInt(3,obj.accNo);
					i = ps.executeUpdate();
					break;
				case 2:
					System.out.println("Enter New Address :-\t");
					ps.setString(1,"Address");
					ps.setString(2,sc.next());
					ps.setInt(3,obj.accNo);
					i = ps.executeUpdate();
					break;
				}				
				if(i>0)
					System.out.println("Updated Into Database...!");
			}
			
			if(a instanceof Current)
			{
				Current obj = (Current)a;
				PreparedStatement ps = conn.prepareStatement("update savings set ? = ? where AccNo= ?");
				System.out.println("Change OverDraft Limit :-");
				
					System.out.println("Enter New OverDraft Limit :-\t");
					ps.setString(1,"OverDraftLimit");
					ps.setString(2,sc.next());
					ps.setInt(3,obj.accNo);
					i = ps.executeUpdate();
												
				if(i>0)
					System.out.println("Updated Into Database...!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
