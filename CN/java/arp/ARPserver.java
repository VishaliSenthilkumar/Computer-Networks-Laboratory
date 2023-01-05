import java.io.*;
import java.net.*;


class ARPserver
{
	public static void main(String args[])
	{
		try
		{
			ServerSocket ss = new ServerSocket(1000);
			Socket s = ss.accept();

			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
				
			String str = in.readLine();

			String ip[]={"165.165.80.80","165.165.79.1"}; 
			String mac[]={"6A:08:AA:C2","8A:BC:E3:FA"};
			
			for(int i = 0; i<ip.length; i++)
			{
				if(str.equals(ip[i]))
				{
					out.writeBytes(mac[i]+'\n');
					break;
				}
			}
			s.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}