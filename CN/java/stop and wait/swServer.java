import java.io.*;
import java.net.*;
public class swServer
{
	Socket sender;
	ObjectOutputStream out;
	ObjectInputStream in;
	String packet,ack,str,msg;
	int n,i=0,seq=0;
	
	public void run()
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Waiting for connection...");
			sender = new Socket("localhost",1000);
			seq=0;
			out = new ObjectOutputStream(sender.getOutputStream());
			out.flush();
			in = new ObjectInputStream(sender.getInputStream());
			str = (String)in.readObject();
			System.out.println("receiver  > "+str);
			System.out.println("Enter data to send : ");
			packet=br.readLine();
			n=packet.length();
			do 
			{
				try
				{
					if(i<n)
					{
						msg=String.valueOf(seq);
						msg=msg.concat(packet.substring(i,i+1));
					}
					else if(i==n)
					{
						msg = "end";
						break;
					}
					out.writeObject(msg);
					seq = (seq==0) ? 1 : 0;
					out.flush();
					System.out.println("Data sent > "+msg);
					ack=(String)in.readLine();
					System.out.println("Waiting for ack...");
					if(ack.equals(String.valueOf(seq)))
					{
						i++;
						System.out.println("receiver > packet received\n\n ");
					}
					else
					{
						System.out.println("Time out sending data...\n\n ");
						seq=(seq==0) ? 1: 0;
					}
				}
				catch(Exception e)
				{
					
				}
			}while(i<n+1);
				System.out.println("All data sent. exiting."); 
		}
		catch(Exception e)
		{
			
		} 
		finally
		{
			try
			{
				in.close();
				out.close();
				sender.close();
			}
			catch(Exception e)
			{
					
			}
		}
	}
	public static void main(String args[])
	{
		swServer s = new swServer();
		s.run();
	}
}