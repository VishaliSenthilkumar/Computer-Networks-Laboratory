import java.io.*;
import java.net.*;

class tracert
{
	public static void main(String args[])
	{
		try
		{
			String str;
			System.out.print("Enter the ip to trace route : ");
			
			BufferedReader buf1 = new BufferedReader(new InputStreamReader(System.in));
			String ip = buf1.readLine();
			
			Runtime H = Runtime.getRuntime();
			Process P = H.exec("tracert "+ip);
			
			InputStream in = P.getInputStream();
			BufferedReader buf2 = new BufferedReader(new InputStreamReader(in));
						
			while((str=buf2.readLine())!=null)
			{
				System.out.println(" "+str);
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
	}
}