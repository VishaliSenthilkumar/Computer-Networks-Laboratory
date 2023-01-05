import java.net.*;
import java.io.*;

class socClient
{	public static void main(String args[])
	{
		Socket s;
		DataInputStream d;
		String date;
		PrintStream p;
		
		try
		{
			s = new Socket("localhost",2000);
			while(true)
			{
				d = new DataInputStream(s.getInputStream());
				date = d.readLine();
				System.out.println("The date in the server is:"+date); 
				
				p=new PrintStream(s.getOutputStream()); 
				p.println("InetAddress.getLocalHost()");
			}
		} 
		catch(IOException e) 
		{ 
			System.out.println("THE EXCEPTION is :"+e); 
		}
	}
}