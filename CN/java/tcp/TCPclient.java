import java.net.* ;
import java.io.*;
public class TCPclient
{
	public static void main(String srgs[]) throws IOException
	{
		Socket s = new Socket("localhost",3000);
		
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println("hello from client");
		pr.flush();
		
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		
		String str = bf.readLine();
		System.out.println("server : " + str);
	}
}