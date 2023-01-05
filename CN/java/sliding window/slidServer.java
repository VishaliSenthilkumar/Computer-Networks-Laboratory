import java.net.*;
import java.io.*;

public class slidServer
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss = new ServerSocket(1000);
		Socket s = ss.accept();
		DataInputStream in = new DataInputStream(System.in);
		DataInputStream in1 = new DataInputStream(s.getInputStream());
		String buff[] = new String[8];
		PrintStream p;
		
		int sptr = 0, sws = 8, nf, ano, i ;
		String ch;
		
		do 
		{
			p = new PrintStream(s.getOutputStream());
			System.out.print("Enter the no. of frames : ");
			nf =  Integer.parseInt(in.readLine());
			p.println(nf);
			
			if(nf <= sws-1)
			{
				System.out.println("Enter "+nf+" messages to be send\n");
				for(i=1; i<=nf; i++)
				{
					buff[sptr]=in.readLine();
					p.println(buff[sptr]);
					sptr=++sptr%8;
				}
				
				sws-=nf;
				System.out.print("Acknowledgement received");
				//ano = Integer.parseInt(in1.readLine());
				sws+=nf;
			}
			else
			{
				System.out.print("The no. of frames exceeds window size");
				break;
			}
			System.out.print("\nDo you want to send more frames : ");
			ch = in.readLine();
			p.println(ch);
			
		} while(ch.equals("yes"));
		s.close();
	}
}