import java.net.*;
import java.io.*;

public class slidClient
{
	public static void main(String args[])throws Exception
	{
		Socket s = new Socket(InetAddress.getLocalHost(),1000);
		DataInputStream in = new DataInputStream(s.getInputStream());
		PrintStream p = new PrintStream(s.getOutputStream());
		
		int i = 0, rptr = -1, rws=8, nf;
		String buff[] = new String[8];
		String ch;
		System.out.println();
		do
		{
			nf =  Integer.parseInt(in.readLine());
			
			if(nf <= rws-1)
			{
				for(i=1; i<=nf; i++)
				{
					rptr=++rptr%8;
					buff[rptr]=in.readLine();
					System.out.println("The received Frame " +rptr+" is : "+buff[rptr]);
				}
				
				rws-=nf;
				System.out.print("\nAcknowledgement sent\n");
				//p.println(rptr+1);
				rws+=nf;
			}
			else
			{
				break;
			}
			ch = in.readLine();
		}while(ch.equals("yes"));
	}
}