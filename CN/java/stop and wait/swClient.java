import java.io.*;
import java.net.*;
public class swClient
{
	ServerSocket receiver;
	Socket conn=null;
	ObjectOutputStream out;
	ObjectInputStream in;
	String packet,ack,data;
	int i=0,seq=0;
	
	public void run()
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			receiver = new ServerSocket(2004,1000);
			System.out.println("Waiting for connection ");
			conn = receiver.accept();
			seq = 0;
			System.out.println("Connection established");
			out=new ObjectOutputStream(conn.getOutputStream()); 
			out.flush(); 
			in=new ObjectInputStream(conn.getInputStream()); 
			out.writeObject("connected ."); 
			do
			{
				try
				{
					packet=(String)in.readObject(); 
					if(Integer.valueOf(packet.substring(0,1))==seq)
					{ 
						data+=packet.substring(1); 
						seq=(seq==0)?1:0; 
						System.out.println("\n\nreceiver >"+packet);
					}
					else
					{
						System.out.println("\n\nreceiver >"+packet +" duplicate data");
					}
					if(i<3)
					{
						out.writeObject(String.valueOf(seq));
						i++;
					}
					else
					{
						out.writeObject(String.valueOf((seq+1)%2)); 
						i=0;
					}
				}
				catch(Exception e){} 
			}while(!packet.equals("end")); 
			System.out.println("Data recived="+data); 
			out.writeObject("connection ended .");
		}
		catch(Exception e){} 
		finally
		{ 
			try
			{
				in.close(); 
				out.close(); 
				receiver.close(); 
			}
			catch(Exception e){} 
		} 
	}
	public static void main(String args[])
	{
		swClient s = new swClient();
		while(true)
		{
			s.run();
		}
	}
}