import java.net.* ;
import java.io.*;
public class TCPserver
{
	public static void main(String srgs[]) throws IOException
	{
		ServerSocket ss = new ServerSocket(3000);
		Socket s = ss.accept();
		System.out.println("client connected");
		
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		
		String str = bf.readLine();
		System.out.println("client : " + str);
		
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println("hello from server");
		pr.flush();
	}
}