import java.io.*;
import java.net.*;


public class UDPClient {
	public static void main(String args[]) {
		try{
		DatagramSocket client = new DatagramSocket();
		InetAddress address = InetAddress.getByName("localhost");
		String str = "message from client!";
		byte[] buf = str.getBytes();
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 5000);
		client.send(packet);
		client.close();
		}
		catch(Exception e) { System.out.println(e); }
	}
}
