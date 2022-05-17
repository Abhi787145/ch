import java.io.*;
import java.net.*;



public class MyClient {
	public static void main(String args[]) {
	try
	{
	Socket s = new Socket("localhost", 5000);

		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1="", str2="";

		while(!str1.equals("stop")) {
			str1 = br.readLine();
			dout.writeUTF(str1);
			str2 = (String) din.readUTF();
			System.out.println(str2);
		}

		s.close();
		din.close();
		dout.close();
		br.close();
	}
	catch(Exception e) {System.out.println(e); }
	}
}
