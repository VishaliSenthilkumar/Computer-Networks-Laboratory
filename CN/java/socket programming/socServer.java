import java.net.*;
import java.io.*;
import java.util.*;

class socServer
{
	public static void main(String args[])
	{
		ServerSocket ss;
		Socket s;
		DataInputStream in;
		String inet;
		PrintStream p;
		
		try
		{
			ss = new ServerSocket(2000);

			s = ss.accept();
			while(true)
			{	
				p = new PrintStream(s.getOutputStream());
				Date d = new Date();
				p.println(d);
				
				in = new DataInputStream(s.getInputStream());
				inet = in.readLine();
				System.out.println("The client system address is : " + inet);			
			}			
			//p.close();
		}
		catch(IOException e)
		{
			System.out.println("The exception is : " + e);
		}
	}
}