import java.io.*;
import java.net.*;
import java.util.*;

class ARPclient
{
	public static void main(String args[])
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			Socket s = new Socket("localhost",1000);
			
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			//System.out.println("Enter the ip : ");
			//String str =  in.readLine();
			String str = sc.nextLine();
			dout.writeBytes(str+'\n');
			String str1 = din.readLine();
			
			System.out.println("The physical address is : "+str1);
			s.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}