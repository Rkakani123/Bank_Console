import java.io.*;

public class Mini_Statement
{
	public static void createFile(int no)
	{
		try
		{
			File file = new File("G:\\Project\\Mini-Statements\\"+no+".txt");
			boolean newFCreated = file.createNewFile();
			if(newFCreated)
				System.out.println("File Created...!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void appendFile(int fileName, Log l)
	{
		try
		{
			String s = l.tID+"\t"+l.tMsg+"\t"+l.tdate;
			File file = new File("G:\\Project\\Mini-Statements\\"+fileName+".txt");
			OutputStream os = new FileOutputStream(file,true);
			String nLine = System.getProperty("line.separator");
			os.write(nLine.getBytes());
			os.write(s.getBytes(),0,s.length());
			os.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void readFile(int fileName) 
	{
		try
		{
			File file = new File("G:\\Project\\Mini-Statements\\"+fileName+".txt");
			FileReader fw = new FileReader(file);
			BufferedReader bw = new BufferedReader(fw);
			String st ;
			while((st=bw.readLine())!=null)
			{
				System.out.println(st);
			}
			bw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void deleteFile(int fileName)
	{
		try
		{
			File file = new File("G:\\Project\\Mini-Statements\\"+fileName+".txt");
			file.delete();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//public static void main(String[] args)
	
}
