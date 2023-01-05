import java.io.*;
import java.net.*;
class RARPclient
{
	public static void main(String args[])
	{
		try
		{
			  DatagramSocket client = new DatagramSocket();
			  InetAddress addr = InetAddress.getByName("127.0.0.1");
			  byte[] s = new byte[1024];
			  byte[] r = new byte[1024];
			  
			  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			  System.out.println("Enter the physical address MAC : ");
			  
			  String str = in.readLine();
			  s = str.getBytes();
			  
			  DatagramPacket sender = new DatagramPacket(s, s.length, addr, 1000);
			  client.send(sender);
			  
			  DatagramPacket receiver = new DatagramPacket(r,r.length);
			  client.receive(receiver);
			  
			  String str1 = new String(receiver.getData());
			  System.out.println("The Logical address is "+str1.trim());
			  client.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}