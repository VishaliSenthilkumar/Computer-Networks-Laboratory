import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UDPserver
{
	public static void main(String args[]) throws IOException
	{
		DatagramSocket ds = new DatagramSocket();
		
		InetAddress ip = InetAddress.getByName("localhost");
		
		byte[] sd = new byte[1024];
		
		String msg = "Hello Server! This is UDP client";
		
		sd = msg.getBytes();
		
		DatagramPacket pkt = new DatagramPacket(sd,sd.length,ip,5000);
		
		ds.send(pkt);
		ds.close();
	}
} 