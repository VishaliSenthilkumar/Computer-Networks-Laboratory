import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UDPserver
{
	public static void main(String args[]) throws IOException
	{
		DatagramSocket ss = new DatagramSocket(5000);
		
		byte[] rd = new byte[1024];
		
		DatagramPacket rp = new DatagramPacket(rd,rd.length);
		
		ss.receive(rp);
		
		InetAddress ip = rp.getAddress();
		
		String msg = new String(rd,0,rp.getLength());
		
		System.out.println("client : " + msg);
		System.out.println("client ip : " + ip);

		ss.close();
	}
}