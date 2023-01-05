import java.util.*;
import java.io.*;
import java.net.*;

class ping
{
	public static void main(String args[])
	{
		try
		{
			String str;
// 			System.out.print("Enter the ip to ping : ");
//
// 			BufferedReader buf1 = new BufferedReader(new InputStreamReader(System.in));
// 			String ip = buf1.readLine();

            Scanner sc = new Scanner(System.in);
            String ip = sc.nextLine();
			
			Runtime H = Runtime.getRuntime();
			Process P = H.exec("ping "+ip);
			
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