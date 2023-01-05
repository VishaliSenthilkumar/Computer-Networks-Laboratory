import java.io.*;
import java.util.*;
import java.net.*;

class RARPserver
{
	public static void main(String args[])
	{
		try
		{
			DatagramSocket server = new DatagramSocket(1000);
			byte[] s = new byte[1024];
			byte[] r = new byte[1024];
			
			DatagramPacket receiver = new DatagramPacket(r, r.length);
			server.receive(receiver);
			
			String str =  new String(receiver.getData());
			String str1 = str.trim();
			
			InetAddress addr = receiver.getAddress();
			int port = receiver.getPort();
			
			String ip[] = {"165.165.80.80", "165.165.79.1"};
			String mac[] = {"6A:08:AA:C2", "8A:BC:E3:FA"};
			
			for(int i=0; i<ip.length; i++)
			{
				if(str1.equals(mac[i]))
				{
					s = ip[i].getBytes();
					DatagramPacket sender = new DatagramPacket(s,s.length,addr,port);
					server.send(sender);
					break;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}