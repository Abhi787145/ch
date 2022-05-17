import java.io.*;
import java.net.*;



public class UDPServer {
	public static void main(String args[]) {
		try {
			DatagramSocket server = new DatagramSocket(5000);
			byte[] buf = new byte[256];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			server.receive(packet);
			String str = new String(packet.getData(), buf.length);
			System.out.println(str);
		}
		catch(Exception e) { System.out.println(e); }
	}
}
